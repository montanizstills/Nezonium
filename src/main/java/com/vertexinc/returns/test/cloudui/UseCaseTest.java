package com.vertexinc.returns.test.cloudui;

import com.vertexinc.returns.test.cloudui.util.DriverHandler;
import com.vertexinc.returns.test.cloudui.util.Environment;
import com.vertexinc.returns.test.cloudui.util.Page;
import com.vertexinc.returns.test.cloudui.util.PageInterface;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


/**
 * This framework aims to reduce future testing labor as tests (class UseCaseTest) implement behaviours of pre-defined pages.
 * The Test Suite is effective when calling upon the 'actions' of pre-defined web/site pages. AIM: Bridges gap between engineers.
 * This use case draws upon the behaviour of the PageInterface.
 * The PageInterface consumes a DriverHandler, who consumes a WebDriver.
 * This architecture aims to alleviate `mistakes` in testing, by enforcing strict type requirements. Such as <Test extends PageBehaviour>
 **/

public class UseCaseTest implements PageInterface {

    private final Environment environment = Environment.VERTEX_HOME_PAGE;
    private DriverHandler driverHandler;
    private WebDriver browser;

    //    Test that Framework can open webpage. The demo webpage will be Vertex Corporate home page.
    public static void main(String[] args) {

    }

    @Test
    public void Test_LoadCorporateWebPage() {
        WebDriverManager.iedriver().setup();
        this.browser = new InternetExplorerDriver();
        this.driverHandler = new DriverHandler(this.browser);

        //Given:
        String expectedURL = environment.getURL();
        Page page = new Page(getDriverHandler());

        //When:
        page.navigateTo(expectedURL);

        //Then:
        String actualURL = page.getCurrentURL();
        Assert.assertEquals(expectedURL, actualURL);

        //clean up
        getDriverHandler().tearDown();
    }//End Test Case

    @Override
    public DriverHandler getDriverHandler() {
        return this.driverHandler;
    }


}//End MyTestClass


