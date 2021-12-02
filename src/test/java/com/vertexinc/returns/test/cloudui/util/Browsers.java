//package com.vertexinc.returns.test.cloudui.util;
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
//public enum Browsers {
//
//    FIREFOX(WebDriverManager.firefoxdriver(),new FirefoxDriver()),
//    CHROME(WebDriverManager::chromedriver, ChromeDriver::new, "Chrome"),
//    OPERA(WebDriverManager::operadriver, OperaDriver::new, "Opera"),
//    //    CHROMIUM(WebDriverManager::chromiumdriver, ChromiumDriver::new), //Cant be instantiated??, protected access rights.
//    IE(WebDriverManager::iedriver, InternetExplorerDriver::new, "InternetExplorer");
//
//    private final WebDriver driver = null;
//    private final WebDriverManager webDriverManager = null;
//
//    Browsers(Function<WebDriverManager, WebDriver> webDriverFunction) {
////        this.webDriverManager
//        this.driver = webDriverFunction.apply(this.webDriverManager);
//    }
//
//    Browsers(WebDriverManager driverManager, WebDriver webDriver) {
//
//    }
//
//
//    public WebDriver getInstance() {
//        return this.driver;
//    }
//}
