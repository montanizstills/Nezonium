package com.vertexinc.returns.test.cloudui;

import com.vertexinc.returns.test.cloudui.annotations.ScreenShotOnFail;
import com.vertexinc.returns.test.cloudui.annotations.UseDriver;
import com.vertexinc.returns.test.cloudui.util.Browsers;
import com.vertexinc.returns.test.cloudui.util.DriverHandler;
import com.vertexinc.returns.test.cloudui.util.Page;
import io.github.bonigarcia.seljup.EnabledIfBrowserAvailable;
import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.extension.RegisterExtension;
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
    @RegisterExtension
    public static SeleniumJupiter selJup = new SeleniumJupiter();

//    @ParameterizedTest(name = "Executing Test: {displayName} with {arguments}")
//    @ArgumentsSource(DriverProvider.class)
    @Test @UseDriver(browser = Browsers.CHROME)
    public void getVertexHomePage(WebDriver driver){
        //Situation: I open Vertex Corporate Home Page
        //[
        //Given a url with value "{value}"
        String url = "https://vertexinc.com";

        //When I open a webpage and navigate to the url
        Page myTestPage = new Page(new DriverHandler(driver));
        myTestPage.navigateTo(url);

        //When...
        //When...

        //Then the current browser url should be {value}
        String currentURL = myTestPage.getCurrentURL();
        Assertions.assertEquals(url,currentURL);
        //]
    }
}