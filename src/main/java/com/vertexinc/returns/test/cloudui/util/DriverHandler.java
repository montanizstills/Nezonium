package com.vertexinc.returns.test.cloudui.util;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public final class DriverHandler implements DriverHandlerInterface {

    private Browsers browser;
    private WebDriver driver;
    private final FluentWait<WebDriver> waitDriver;

//    public DriverHandler(Browsers browser) {
//        this.browser = browser;
//        waitDriver = new FluentWait<>(getDriver())
//                .withTimeout(Duration.ofMillis(12000))
//                .pollingEvery(Duration.ofMillis(250))
//                .ignoring(NoSuchElementException.class);
//    }

    public DriverHandler(WebDriver driver) {
        this.driver=driver;
        waitDriver = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofMillis(12000))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(NoSuchElementException.class);
    }

    @Override
    public WebDriver getDriver() {
        if (this.driver == null) {
            return this.driver = createDriverInstance();
        }
        return this.driver;
    }

    private WebDriver createDriverInstance() {
        return this.browser.getInstance();
    }

    @Override
    public FluentWait<WebDriver> getWait() {
        return this.waitDriver;
    }

    @Override
    public void destroyDriver() {
        this.tearDown();
    }
}
