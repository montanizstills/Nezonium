package com.vertexinc.returns.test.cloudui;

import com.vertexinc.returns.test.cloudui.util.Browsers;
import com.vertexinc.returns.test.cloudui.util.DriverHandler;
import com.vertexinc.returns.test.cloudui.util.Page;
import org.junit.After;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;


/**
 * This framework aims to reduce future testing labor as tests (class UseCaseTest) implement behaviours of pre-defined pages.
 * The Test Suite is effective when calling upon the 'actions' of pre-defined web/site pages. AIM: Bridges gap between engineers.
 * This use case draws upon the behaviour of the PageInterface.
 * The Page consumes a DriverHandler, who consumes a WebDriver.
 * This architecture aims to alleviate `mistakes` in testing, by enforcing strict type requirements and implicit waiting.
 **/

public class UseCaseTest {

    private DriverHandler driverHandler;
    private WebDriver browser;


    @Test
    //    Test that Framework can open webpage. The demo webpage will be Vertex Corporate home page.
    public void Test_LoadCorporateWebPage() {

        this.browser = Browsers.EDGE.getInstance();
        this.driverHandler = new DriverHandler(getBrowser());

        //Given:
        String expectedURL = "https://www.vertexinc.com/";
        Page page = new Page(getDriverHandler());

        //When:
        page.navigateTo(expectedURL);

        //Then:
        String actualURL = page.getCurrentURL();
        Assert.assertEquals(expectedURL, actualURL);

        getDriverHandler().takeScreenShot();

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


