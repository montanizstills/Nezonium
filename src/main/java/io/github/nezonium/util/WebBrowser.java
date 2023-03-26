package io.github.nezonium.util;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.function.Supplier;

public enum WebBrowser {
    FIREFOX(WebDriverManager::firefoxdriver),
    // TODO - Investigate Shell browser vs SelJup version error. Check capabilities.
    @Deprecated CHROME(WebDriverManager::chromedriver),
    @Deprecated INTERNET_EXPLORER(WebDriverManager::iedriver),
    EDGE(WebDriverManager::edgedriver),
    SAFARI(WebDriverManager::safaridriver);
    // TODO - mobile-OS driver.

    private final Supplier<WebDriverManager> webDriverManagerSupplier;

    WebBrowser(Supplier<WebDriverManager> webDriverManagerSupplier) {
        this.webDriverManagerSupplier = webDriverManagerSupplier;
    }

    public Supplier<WebDriverManager> getWebDriverManagerSupplier() {
        return this.webDriverManagerSupplier;
    }

}

