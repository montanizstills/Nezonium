package com.vertexinc.returns.test.cloudui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.function.Supplier;

public enum Browsers {

    FIREFOX(WebDriverManager::firefoxdriver, FirefoxDriver::new),
    CHROME(WebDriverManager::chromedriver, ChromeDriver::new),
    OPERA(WebDriverManager::operadriver, OperaDriver::new),
//    CHROMIUM(WebDriverManager::chromiumdriver, ChromiumDriver::new), //Cant be instantiated??, protected access rights.
    IE(WebDriverManager::iedriver, InternetExplorerDriver::new);

    private WebDriver driver;

    Browsers(Supplier<WebDriverManager> webDriverManagerSupplier, Supplier<WebDriver> driverSupplier) {
        WebDriverManager wdm = webDriverManagerSupplier.get();
//        wdm.browserVersion("0.010.0");
        wdm.setup();
        this.driver = driverSupplier.get();
    }

    public WebDriver getInstance() {
        return this.driver;
    }
}
