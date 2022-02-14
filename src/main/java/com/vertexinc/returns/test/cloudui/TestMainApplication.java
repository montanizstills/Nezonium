package com.vertexinc.returns.test.cloudui;

import com.vertexinc.returns.test.cloudui.annotations.ScreenShotOnFail;
import com.vertexinc.returns.test.cloudui.annotations.UseDriver;
import com.vertexinc.returns.test.cloudui.util.Page;
import com.vertexinc.returns.test.cloudui.util.SeleniumJupiterProvider;
import com.vertexinc.returns.test.cloudui.util.WebBrowser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

/**
 * This framework aims adheres to the Page Object Model.
 * The following test is a demonstration. This use case draws upon the behaviour of the PageInterface. The PageInterface follows Open-Closed principle.
 * This framework observes DOM state before element interaction to abstract `test.wait()` from user focus and readjust it to building the test at hand!
 **/

//Sample Test Class
@DisplayName("My Sample Test Suite")
public class TestMainApplication {

    //Sample Test Method
    @UseDriver(browser = {WebBrowser.EDGE})
    @ScreenShotOnFail(screenshotOutputDir = ScreenShotOnFail.CHROME_DIR_DEFAULT)
    public void should_Open_GoogleSearchEngine_Page(WebBrowser webBrowser) {
        SeleniumJupiterProvider.setUp(webBrowser); //embed in every test, accomplishable through inheritance? looks ugly siting there.

        //Situation-Scenario: I open Google search page.
        //[
        //Given an url with value "{value}."
        String url = "https://www.google.com/";

        //When I open a webpage and navigate to the url.
        Page myTestPage = new Page();
        myTestPage.navigateTo(url);

        //When...
        //When...

        //Then the current browser url should be {value}
        String currentURL = myTestPage.getCurrentURL();
        Assertions.assertEquals(url, currentURL);
        //]
    }

}//End MainApplication