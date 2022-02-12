package com.vertexinc.returns.test.cloudui.util;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public final class DriverHandler implements DriverHandlerInterface {

    private WebDriver driver;
    private final FluentWait<WebDriver> waitDriver;

    public DriverHandler() {
        waitDriver = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofMillis(12000))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(NoSuchElementException.class);
    }

    @Override
    public WebDriver getDriver() {
        if (this.driver == null) {
            return this.driver = SeleniumJupiterProvider.getInstance().getConfig().getManager().create();
        }
        return this.driver;
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
