
package com.vertexinc.returns.test.cloudui.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.function.Supplier;

/**
 * NOT READY FOR IMPLEMENTATION. PLEASE DO NOT USE IN CODE
 **/
public enum Browsers {

    FIREFOX(WebDriverManager::firefoxdriver),
    CHROME(WebDriverManager::chromedriver),
    OPERA(WebDriverManager::operadriver),
    IE(WebDriverManager::iedriver),
    EDGE(WebDriverManager::edgedriver);

    private final WebDriver driver;
//    private final WebDriverManager webDriverManager;

    Browsers(Supplier<WebDriverManager> webDriverManagerSupplier) {
//        this.webDriverManager = webDriverManagerSupplier.get();
        this.driver = webDriverManagerSupplier.get().create();
    }

//    private WebDriverManager getWebDriverManager() {
//        return this.webDriverManager;
//    }

    public WebDriver getDriver() {
        return this.driver;
    }


}

