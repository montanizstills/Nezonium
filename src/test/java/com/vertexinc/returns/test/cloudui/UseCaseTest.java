package com.vertexinc.returns.test.cloudui;

import com.vertexinc.returns.test.cloudui.util.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;


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
    @Test
    public void Test_LoadCorporateWebPage() {
//        WebDriverManager.edgedriver().setup();
//        this.browser = new EdgeDriver(); //OLD
        browser = Browsers.CHROME.getInstance(); //NEW
        this.driverHandler = new DriverHandler(this.browser);

        //Given:
        String expectedURL = "https://www.vertexinc.com/";
        Page page = new Page(getDriverHandler());
        //When:
        page.getDriverHandler().navigateTo(expectedURL);
//        page.navigateTo(expectedURL);
        //Then:
        String actualURL = page.getCurrentURL();
        Assert.assertEquals(expectedURL, actualURL);

        //clean up
        getDriverHandler().tearDown();
    }//End Test Case

    public Environment getEnvironment() {
        return this.environment;
    }

    @Override
    public DriverHandler getDriverHandler() {
        return this.driverHandler;
    }

}//End MyTestClass


