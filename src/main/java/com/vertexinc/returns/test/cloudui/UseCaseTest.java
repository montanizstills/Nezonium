package com.vertexinc.returns.test.cloudui;

import com.vertexinc.returns.test.cloudui.rules.ScreenShotOnFailRule;
import com.vertexinc.returns.test.cloudui.util.Browsers;
import com.vertexinc.returns.test.cloudui.util.DriverHandler;
import com.vertexinc.returns.test.cloudui.util.Page;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;

/**
 * This framework aims to reduce future testing labor as tests (class UseCaseTest) implement behaviours of pre-defined pages.
 * The Test Suite is effective when calling upon the 'actions' of pre-defined web/site pages. AIM: Bridges gap between engineers.
 * This use case draws upon the behaviour of the PageInterface.
 * The Page consumes a DriverHandler, who consumes a WebDriver.
 * This architecture aims to alleviate `mistakes` in testing, by enforcing strict type requirements and implicit waiting.
 **/

public class UseCaseTest {

    private DriverHandler driverHandler;
    private final WebDriver browser = Browsers.EDGE.getInstance();

    @Rule public TestName name = new TestName();

    //The way File.java normalizes the file path, you mustn't add a preceding forward-slash in filepath.
    @Rule public ScreenShotOnFailRule screenShotOnFail = new ScreenShotOnFailRule("src/main/resources/",getTestName(),getBrowser());



    @Test
    //    Test that Framework can open webpage. The demo webpage will be Vertex Corporate home page.
    public void Test_LoadCorporateWebPage() {

        this.driverHandler = new DriverHandler(getBrowser());

        //Given:
        String expectedURL = "https://www.vertexinc.com/";
        Page page = new Page(getDriverHandler());

        //When:
        page.navigateTo(expectedURL);

        //Then:
        String actualURL = page.getCurrentURL();

        Assert.assertEquals(expectedURL, actualURL);

    }//End Test Case

    public DriverHandler getDriverHandler() {
        return this.driverHandler;
    }

    public WebDriver getBrowser() {
        return browser;
    }

    public String getTestName(){
        return this.name.getMethodName();
    }
}//End MyTestClass


