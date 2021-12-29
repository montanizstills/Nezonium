package com.vertexinc.returns.test.cloudui.util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public final class DriverHandler implements DriverHandlerInterface{

    private final WebDriver driver;
    private final FluentWait<WebDriver> waitDriver;

    public DriverHandler(final WebDriver driver) {
        this.driver = driver;
        waitDriver = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofMillis(12000))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(NoSuchElementException.class);
    }

    @Override
    public WebDriver getDriver() {
        return this.driver;
    }

    @Override
    public FluentWait<WebDriver> getWait() {
        return this.waitDriver;
    }
}
