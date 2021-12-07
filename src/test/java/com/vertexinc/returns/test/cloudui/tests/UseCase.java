package com.vertexinc.returns.test.cloudui.tests;

import com.vertexinc.returns.test.cloudui.util.resources.Environment;
import com.vertexinc.returns.test.cloudui.util.resources.page.CloudLogInPageInterface;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


//This use case uses the Cloud login page as a basis. To change the page skeleton, please implement a new interface.
//This framework aims to reduce future testing labor as tests (class UseCass) implement behaviours of pre-defined pages.
//The Test Suite is effective when calling upon the 'actions' of pre-defined web/site pages. Bridges gap between engineers.
public class UseCase implements CloudLogInPageInterface {

//    Test Framework can open webpage.

//    Demo webpage will be Vertex Corporate home page.
    private final Environment environment = Environment.VERTEX_HOME_PAGE;
    private WebDriver browser;

    @Test
    public void Test01() {
//        Start Logger;
//        Logger logger = LoggerFactory.getLogger("MyTest01");

        //Given:
        String expected = this.environment.getURL();


        //When:
        WebDriverManager.iedriver().setup();
        this.browser = new InternetExplorerDriver();
//        browser = Browsers.IE.getInstance();

//        logger.atDebug().addKeyValue("", line_to_exec){if obj => object.toString()}
//        logger.atDebug().addKeyValue("", browser = new InternetExplorerDriver());
//        OR
//        logger.atDebug().addKeyValue("", browser = Browsers.IE.getInstance());

        browser.navigate().to(getEnvironment().getURL());
        String actual = browser.getCurrentUrl();

        //Then:
        Assert.assertEquals(expected, actual);

        //clean up
        this.tearDown();

    }//End Test Case

    public Environment getEnvironment() {
        return this.environment;
    }

    @Override
    public WebDriver getBrowser() {
        return this.browser;
    }

    @Override
    @After //remove @After to keep page open after testing. Please add @After annotation after testing.
    public void tearDown() {
        CloudLogInPageInterface.super.tearDown();
    }

}//End MyTestClass


//public class testUI {
//
//    @Test
//    public void Test0(){
//        WebDriver webDriver = BrowserHandlerFactory.FIREFOX.getDriver();
//        SearchPage searchPage = new SearchPage(webDriver);
//        searchPage.navigateTo();
//        searchPage.selectLanguage("English");
//        searchPage.search("apple");
//        searchPage.clickSearch();
//        AppleJuiceWidget appleJuiceWidget = searchPage.clickAppleJuice();
//        appleJuiceWidget.leaveProductReview("This is a product review");
//        webDriver.close();
//    }
//}
