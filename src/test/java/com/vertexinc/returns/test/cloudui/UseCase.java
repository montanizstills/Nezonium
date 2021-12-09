package com.vertexinc.returns.test.cloudui;

import com.vertexinc.returns.test.cloudui.util.DriverHandler;
import com.vertexinc.returns.test.cloudui.util.Environment;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


/**
 * This framework aims to reduce future testing labor as tests (class UseCase) implement behaviours of pre-defined pages.
 * The Test Suite is effective when calling upon the 'actions' of pre-defined web/site pages. AIM: Bridges gap between engineers.
 * This use case draws upon the behaviour of the PageInterface and TestInterface.
 * The PageInterface consumes a DriverHandler, who consumes a WebDriver.
 * The TestInterface consumes an environment (TBD), a Driver, in this instance a ChromeDriver, and a DriverHandler who consumes our ChromeDriver.
 * This architecture aims to alleviate `mistakes` in testing, by enforcing strict type requirements. Such as <Type extends SuperClass>
 **/

public class UseCase extends TestImpl {

//    Test that Framework can open webpage.
//    The demo webpage will be Vertex Corporate home page.

    private final Environment environment = Environment.VERTEX_HOME_PAGE;
    private DriverHandler driverHandler;
    private WebDriver browser;

    @Test
    public void Test_LoadCorporateWebPage() {

        //Given:
        String expectedURL = this.environment.getURL();
        WebDriverManager.iedriver().setup();
        this.browser = new InternetExplorerDriver(); //OLD
        //browser = Browsers.IE.getInstance(); //NEW
        this.driverHandler = new DriverHandler(this.browser);

        //When:
        getDriverHandler().navigateTo(getEnvironment().getURL());

        //Then:
        String actualURL = getDriverHandler().getDriver().getCurrentUrl();
        Assert.assertEquals(expectedURL, actualURL);

        //clean up
        getDriverHandler().tearDown();

    }//End Test Case


    @Override
    public Environment getEnvironment() {
        return this.environment;
    }

    @Override
    public DriverHandler getDriverHandler() {
        return this.driverHandler;
    }

}//End MyTestClass


