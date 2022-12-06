package io.github.nezonium.util;


import com.github.git_leon.leonium.browsertools.factories.BrowserHandlerFactoryInterface;
import com.github.git_leon.leonium.browsertools.factories.DesiredCapabilitiesFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.util.function.Function;
import java.util.function.Supplier;

public enum WebBrowserHandlerFactory implements BrowserHandlerFactoryInterface {
    CHROME(DesiredCapabilitiesFactory::getChrome,
            (caps) -> new ChromeDriver((new ChromeOptions()).merge(caps)),
            WebDriverManager.chromedriver()),
    FIREFOX(DesiredCapabilitiesFactory::getFirefox,
            (caps) -> new FirefoxDriver((new FirefoxOptions()).merge(caps)),
            WebDriverManager.firefoxdriver()),
    HEADLESS_CHROME(DesiredCapabilitiesFactory::getHeadlessChrome,
            (caps) -> new ChromeDriver((new ChromeOptions()).merge(caps)),
            WebDriverManager.chromedriver()),
    HEADLESS_FIREFOX(DesiredCapabilitiesFactory::getHeadlessFirefox,
            (caps) -> new FirefoxDriver((new FirefoxOptions()).merge(caps)),
            WebDriverManager.firefoxdriver()),
    @Deprecated
    INTERNET_EXPLORER(DesiredCapabilitiesFactory::getDefault,
            (caps) -> new InternetExplorerDriver(new InternetExplorerOptions().merge(caps)),
            WebDriverManager.iedriver()),
    EDGE(DesiredCapabilitiesFactory::getDefault,
            (caps) -> new EdgeDriver(new EdgeOptions().merge(caps)),
            WebDriverManager.edgedriver()),
    SAFARI(DesiredCapabilitiesFactory::getDefault,
            (caps) -> new SafariDriver(new SafariOptions().merge(caps)),
            WebDriverManager.safaridriver());

    private final Function<Capabilities, WebDriver> webDriverConstructor;
    private final Supplier<Capabilities> capabilitiesSupplier;
    private final WebDriverManager webDriverManager;

    private WebBrowserHandlerFactory(Supplier<Capabilities> capabilitiesSupplier, Function<Capabilities, WebDriver> constructor, WebDriverManager webDriverManager) {
        this.webDriverConstructor = constructor;
        this.capabilitiesSupplier = capabilitiesSupplier;
        this.webDriverManager = webDriverManager;
    }

    public Function<Capabilities, WebDriver> getWebDriverConstructor() {
        return this.webDriverConstructor;
    }

    public Supplier<Capabilities> getCapabilitiesSupplier() {
        return this.capabilitiesSupplier;
    }

    public WebDriverManager getWebDriverManager() {
        return this.webDriverManager;
    }
}