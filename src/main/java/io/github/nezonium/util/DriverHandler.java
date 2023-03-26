package io.github.nezonium.util;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public final class DriverHandler implements DriverHandlerInterface {

    private final WebDriver driver;
    private final FluentWait<WebDriver> waitDriver;
    private static int timeOutWaitTimeInMillis = 12000;

    public DriverHandler() {
        this.driver = SeleniumJupiterProvider.getInstance().getConfig().getManager().create();
        waitDriver = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofMillis(timeOutWaitTimeInMillis))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(NoSuchElementException.class);
    }

    public static void setTimeOutWaitTimeInMillis(int timeOutWaitTime) {
        timeOutWaitTimeInMillis = timeOutWaitTime;
    }

    @Override
    public WebDriver getDriver() {
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
