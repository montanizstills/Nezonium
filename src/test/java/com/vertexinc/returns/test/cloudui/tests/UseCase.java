package com.vertexinc.returns.test.cloudui.tests;

import com.vertexinc.returns.test.cloudui.resources.Environment;
import com.vertexinc.returns.test.cloudui.util.interfaces.TestInterface;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UseCase implements TestInterface {

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
        WebDriverManager.chromedriver().setup();
        this.browser = new ChromeDriver();
//        browser = Browsers.IE.getInstance();

//        logger.atDebug().addKeyValue("", line_to_exec)
//        logger.atDebug().addKeyValue("", browser = new InternetExplorerDriver());
//        OR
//        logger.atDebug().addKeyValue("", browser = Browsers.IE.getInstance());

        browser.navigate().to("https://www.vertexinc.com");
        String actual = browser.getCurrentUrl();

        //Then:
        Assert.assertEquals(expected, actual);

        //clean up
        this.tearDown();

    }//End Test Case

    @Override
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
        TestInterface.super.tearDown();
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
