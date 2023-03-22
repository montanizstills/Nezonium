package io.github.nezonium;

import io.github.nezonium.annotations.UseDriver;
import io.github.nezonium.util.DriverHandler;
import io.github.nezonium.util.Page;
import io.github.nezonium.util.SeleniumJupiterProvider;
import io.github.nezonium.util.WebBrowser;
import org.junit.jupiter.api.Assertions;

public class BrowserTest {

    @UseDriver(browser = {WebBrowser.EDGE, WebBrowser.FIREFOX})
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
}
