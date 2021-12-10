
package com.vertexinc.returns.test.cloudui.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.function.Supplier;

/**NOT READY FOR IMPLEMENTATION. PLEASE DO NOT USE IN CODE**/
public enum Browsers {

    FIREFOX(WebDriverManager::firefoxdriver, FirefoxDriver::new),
    CHROME(WebDriverManager::chromedriver, ChromeDriver::new),
    OPERA(WebDriverManager::operadriver, OperaDriver::new),
    IE(WebDriverManager::iedriver, InternetExplorerDriver::new),
    EDGE(WebDriverManager::edgedriver, EdgeDriver::new);

    private WebDriver driver;
    private WebDriverManager webDriverManager;

    Browsers(Supplier<WebDriverManager> webDriverManagerSupplier, Supplier<WebDriver> webDriverSupplier) {
        this.webDriverManager = webDriverManagerSupplier.get();
        getWebDriverManager().setup();
        this.driver = webDriverSupplier.get();
    }


    private WebDriverManager getWebDriverManager() {
        return this.webDriverManager;
    }

    public WebDriver getInstance() {
        return this.driver;
    }


}

