package io.github.nezonium;

import com.github.git_leon.leonium.browsertools.factories.BrowserHandlerFactory;
import io.github.nezonium.annotations.ScreenShotOnFail;
import io.github.nezonium.annotations.UseDriver;
import io.github.nezonium.util.Page;
import io.github.nezonium.util.SeleniumJupiterProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

/**
 * This framework aims adheres to the Page Object Model.
 * The following class is a demonstration of the framework.
 * This framework observes DOM state before element interaction to abstract `test.wait()` from user focus and readjust it to building the test at hand!
 **/

//Sample Test Class
@DisplayName("My Sample Test Suite")
public class TestMainApplication {

    //Sample Test Method
    @UseDriver(browser = {BrowserHandlerFactory.CHROME})
    @ScreenShotOnFail
    public void should_Open_GoogleSearchEngine_Page(BrowserHandlerFactory webBrowser) {
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