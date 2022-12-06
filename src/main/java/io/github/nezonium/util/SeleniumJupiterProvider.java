package io.github.nezonium.util;

import com.github.git_leon.leonium.browsertools.factories.BrowserHandlerFactory;
import io.github.bonigarcia.seljup.SeleniumJupiter;

public class SeleniumJupiterProvider {

    private static SeleniumJupiter selJup = new SeleniumJupiter();

    private SeleniumJupiterProvider() {
    }

    public static SeleniumJupiter getInstance() {
        return selJup;
    }

    public static void setUp(BrowserHandlerFactory webBrowser) {
        SeleniumJupiterProvider.getInstance().getConfig().setManager(webBrowser.getWebDriverManager());
    }
}//End SeleniumJupiterProvider class
