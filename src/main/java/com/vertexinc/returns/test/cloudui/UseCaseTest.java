package com.vertexinc.returns.test.cloudui;

import com.vertexinc.returns.test.cloudui.util.Browsers;
import com.vertexinc.returns.test.cloudui.util.DriverHandler;
import com.vertexinc.returns.test.cloudui.util.Page;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;


/**
 * This framework aims to reduce future testing labor as tests (class UseCaseTest) implement behaviours of pre-defined pages.
 * The Test Suite is effective when calling upon the 'actions' of pre-defined web/site pages. AIM: Bridges gap between engineers.
 * This use case draws upon the behaviour of the PageInterface.
 * The PageInterface consumes a DriverHandler, who consumes a WebDriver.
 * This architecture aims to alleviate `mistakes` in testing, by enforcing strict type requirements. Such as <Test extends PageBehaviour>
 **/

public class UseCaseTest {

    private DriverHandler driverHandler;
    private WebDriver browser;


    @Test
    //    Test that Framework can open webpage. The demo webpage will be Vertex Corporate home page.
    public void Test_LoadCorporateWebPage() {

        this.browser = Browsers.CHROME.getInstance();
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


    @After
    public void tearDown() {
        getDriverHandler().tearDown();
    }

    public DriverHandler getDriverHandler() {
        return this.driverHandler;
    }

    public WebDriver getBrowser() {
        return browser;
    }
}//End MyTestClass


