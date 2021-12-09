//
//package com.vertexinc.returns.test.cloudui.log.util;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.opera.OperaDriver;
//import org.openqa.selenium.remote.RemoteWebDriver;
//
//
//import java.util.function.Function;
//import java.util.function.Supplier;
//
//// method reference is used for METHOD INVOKATION DEFERENCE
//public enum Browsers {
//
//    FIREFOX(WebDriverManager::firefoxdriver(), new FirefoxDriver()),
//    CHROME(WebDriverManager::chromedriver, ChromeDriver::new),
//    OPERA(WebDriverManager::operadriver, OperaDriver::new),
//    CHROMIUM(WebDriverManager::chromiumdriver, ChromiumDriver::new),
//    IE(WebDriverManager::iedriver, InternetExplorerDriver::new);
//
//    private final WebDriver driver;
//    private final WebDriverManager webDriverManager = null;
//
//    Browsers(Supplier<WebDriver> webDriverSupplier) {
//        this.driver = webDriverSupplier.get();
//    }
//
//    public WebDriver getInstance() {
//        return this.driver;
//    }
//    }
//
