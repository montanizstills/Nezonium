package com.vertexinc.returns.test.cloudui.util;

import io.github.bonigarcia.seljup.SeleniumJupiter;

public class SeleniumJupiterProvider {

    private static SeleniumJupiter selJup = new SeleniumJupiter();

    private SeleniumJupiterProvider() {
    }//SINGLETON PATTERN

    public static SeleniumJupiter getInstance() {
        return selJup;
    }

    public static void setUp(WebBrowser webBrowser) {
        SeleniumJupiterProvider.getInstance().getConfig().setManager(webBrowser.getWebDriverManagerSupplier().get());
    }
}//End SeleniumJupiterProvider class
