package io.github.nezonium.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.function.Supplier;

public enum WebBrowser {
    FIREFOX(WebDriverManager::firefoxdriver, FirefoxDriver::new),
    // TODO - Investigate 'Input must be set' thrown by FluentWait API
    @Deprecated CHROME(WebDriverManager::chromedriver, ChromeDriver::new),
    OPERA(WebDriverManager::operadriver, OperaDriver::new),
    // TODO - Cannot control driver with this webBrowser. Hence, temporary deprecation. Recommended use: AVOID!
    @Deprecated INTERNET_EXPLORER(WebDriverManager::iedriver, InternetExplorerDriver::new),
    EDGE(WebDriverManager::edgedriver, EdgeDriver::new),
    SAFARI(WebDriverManager::safaridriver, SafariDriver::new);
    // TODO - mobile-OS driver.

    private final Supplier<WebDriver> webDriverSupplier;
    private final Supplier<WebDriverManager> webDriverManagerSupplier;

    WebBrowser(Supplier<WebDriverManager> webDriverManagerSupplier, Supplier<WebDriver> webDriverSupplier) {
        this.webDriverManagerSupplier = webDriverManagerSupplier;
        this.webDriverSupplier = webDriverSupplier;
    }

    public Supplier<WebDriverManager> getWebDriverManagerSupplier() {
        return this.webDriverManagerSupplier;
    }

    private Supplier<WebDriver> getWebDriverSupplier() {
        return this.webDriverSupplier;
    }

}

