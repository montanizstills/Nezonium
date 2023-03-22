package io.github.nezonium.util;

import io.github.bonigarcia.seljup.SeleniumJupiter;

public class SeleniumJupiterProvider {

    private static final SeleniumJupiter selJup = new SeleniumJupiter();

    private SeleniumJupiterProvider() {
    }

    public static SeleniumJupiter getInstance() {
        return selJup;
    }

    public static void setUp(WebBrowser webBrowser) {
        SeleniumJupiterProvider.getInstance().getConfig().setManager(webBrowser.getWebDriverManagerSupplier().get());
    }
}//End SeleniumJupiterProvider class
