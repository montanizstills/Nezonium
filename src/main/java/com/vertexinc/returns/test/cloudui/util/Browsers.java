
package com.vertexinc.returns.test.cloudui.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.function.Supplier;

/**
 * NOT READY FOR IMPLEMENTATION. PLEASE DO NOT USE IN CODE
 **/
public enum Browsers {

    FIREFOX(WebDriverManager::firefoxdriver, FirefoxDriver::new),
    CHROME(WebDriverManager::chromedriver, ChromeDriver::new),
    OPERA(WebDriverManager::operadriver, OperaDriver::new),
    IE(WebDriverManager::iedriver, InternetExplorerDriver::new),
    EDGE(WebDriverManager::edgedriver, EdgeDriver::new);

    private final Supplier<WebDriver> webDriverSupplier;
    private final Supplier<WebDriverManager> webDriverManagerSupplier;

    Browsers(Supplier<WebDriverManager> webDriverManagerSupplier, Supplier<WebDriver> webDriverSupplier) {
        this.webDriverManagerSupplier = webDriverManagerSupplier;
        this.webDriverSupplier = webDriverSupplier;
    }

    public Supplier<WebDriverManager> getWebDriverManagerSupplier() {
        return this.webDriverManagerSupplier;
    }

    public Supplier<WebDriver> getWebDriverSupplier() {
        return this.webDriverSupplier;
    }

    public WebDriver getInstance(){
        getWebDriverManagerSupplier().get().setup();
        return getWebDriverSupplier().get();
    }


}

