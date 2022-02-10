package com.vertexinc.returns.test.cloudui;

import com.vertexinc.returns.test.cloudui.annotations.ScreenShotOnFail;
import com.vertexinc.returns.test.cloudui.annotations.UseDriver;
import com.vertexinc.returns.test.cloudui.util.WebBrowser;
import com.vertexinc.returns.test.cloudui.util.DriverHandler;
import com.vertexinc.returns.test.cloudui.util.Page;
import com.vertexinc.returns.test.cloudui.util.SeleniumJupiterProvider;
import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WebDriver;


/**
 * This framework aims to reduce future testing labor as tests (class UseCaseTest) implement behaviours of pre-defined pages.
 * The Test Suite is effective when calling upon the 'actions' of pre-defined web/site pages. AIM: Bridges gap between engineers.
 * This use case draws upon the behaviour of the PageInterface.
 * The Page consumes a DriverHandler, who consumes a WebDriver.
 * This architecture aims to alleviate `mistakes` in testing, by enforcing strict type requirements and implicit waiting.
 **/

//    Test that Framework can open webpage. The demo webpage will be Vertex Corporate home page.
@DisplayName("Load-Page Test Suite")
public class LoadPage_DemoSuite {


    @UseDriver(browser = {WebBrowser.CHROME, WebBrowser.EDGE})
    @ScreenShotOnFail(screenshotOutputDir = ScreenShotOnFail.CHROME_DIR_DEFAULT)
    public void should_Open_GoogleSearchEngine_Page(WebBrowser webBrowser) {
        SeleniumJupiterProvider.setUp(webBrowser);
        //Situation-Scenario: I open Google search page.
        //[
        //Given an url with value "{value}."
        String url = "https://www.google.com/";

        //When I open a webpage and navigate to the url.
        Page myTestPage = new Page(new DriverHandler());
        myTestPage.navigateTo(url);

        //When...
        //When...

        //Then the current browser url should be {value}
        String currentURL = myTestPage.getCurrentURL();
        Assertions.assertEquals(url, currentURL);
        //]
    }
    @AfterEach
    void stop(){
        SeleniumJupiterProvider.getInstance().getConfig().getManager().quit();
    } //try tear down without explicit @AfterEach

}//End MainApplication