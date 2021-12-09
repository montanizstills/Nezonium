package com.vertexinc.returns.test.cloudui.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

public class DriverHandler implements DriverHandlerInterface{

    private final WebDriver driver;
    private final FluentWait<WebDriver> waitDriver;

    public DriverHandler(WebDriver driver) {
        this.driver = driver;
        waitDriver = new FluentWait<>(getDriver());
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
