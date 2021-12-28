package com.vertexinc.returns.test.cloudui;

import com.vertexinc.returns.test.cloudui.util.Browsers;
import com.vertexinc.returns.test.cloudui.util.DriverHandler;
import com.vertexinc.returns.test.cloudui.util.Environment;
import com.vertexinc.returns.test.cloudui.util.Page;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


/**
 * This framework aims to reduce future testing labor as tests (class UseCaseTest) implement behaviours of pre-defined pages.
 * The Test Suite is effective when calling upon the 'actions' of pre-defined web/site pages. AIM: Bridges gap between engineers.
 * This use case draws upon the behaviour of the PageInterface.
 * The PageInterface consumes a DriverHandler, who consumes a WebDriver.
 * This architecture aims to alleviate `mistakes` in testing, by enforcing strict type requirements. Such as <Test extends PageBehaviour>
 **/

public class UseCaseTest {

    private Environment environment;
    private DriverHandler driverHandler;
    private WebDriver browser;


    //    Test that Framework can open webpage. The demo webpage will be Vertex Corporate home page.
    public void Test_LoadCorporateWebPage(Environment environment, Browsers browsers) {
        this.browser = browsers.getDriver();
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


    public void Test_AssertTrue(Environment environment, Browsers browsers) {
        this.environment = environment;
        this.browser = browsers.getDriver();
        this.driverHandler = new DriverHandler(getBrowser());

        //Given:
        //When:
        //Then:
        Assert.assertTrue(true);

    }

    @After
   public void tearDown(){
        getDriverHandler().tearDown();
    }

    @Test
    public void test1() {
//        Test_AssertTrue(Environment.DEV, Browsers.CHROME);
//        Test_AssertTrue(Environment.DEV, Browsers.EDGE);
//        Test_AssertTrue(Environment.DEV, Browsers.IE);

        Test_LoadCorporateWebPage(Environment.DEV, Browsers.CHROME);
        Test_LoadCorporateWebPage(Environment.DEV, Browsers.EDGE);
        Test_LoadCorporateWebPage(Environment.DEV, Browsers.IE);

    }


    public DriverHandler getDriverHandler() {
        return this.driverHandler;
    }


    public WebDriver getBrowser() {
        return browser;
    }
}//End MyTestClass


