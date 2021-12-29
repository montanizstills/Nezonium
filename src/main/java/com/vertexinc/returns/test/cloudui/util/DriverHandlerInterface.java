package com.vertexinc.returns.test.cloudui.util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;

/**
 * DriverHandler is a class constructed to make use of `smart waits.` Waiting for elements to be rendered
 * on the page before accessing them, whilst avoiding explicit waits such as a sleep() or wait() functions that
 * consumes some time. Advantage? All things are available to the user before 'framework' attempts to access/manipulate
 * them.
 **/
public interface DriverHandlerInterface {
    WebDriver getDriver();

    FluentWait<WebDriver> getWait();

    default String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }

    default WebElement getElement(By by) {
        return getDriver().findElement(by);
    }

    default String getText(By by) {
        return getElement(by).getText();
    }

    default void navigateTo(String url) {
        getDriver().navigate().to(url);
    }

    default Select toSelect(By by) {
        getWait().until(ExpectedConditions.presenceOfElementLocated(by));
        getWait().until(ExpectedConditions.visibilityOf(getElement(by)));
        getWait().until(ExpectedConditions.elementToBeClickable(by));
        getWait().until(ExpectedConditions.not(ExpectedConditions.stalenessOf(getElement(by))));
      //  getWait().until(ExpectedConditions.visibilityOfAllElements(() -> Page.class.getMethods()));
        return new Select(getElement(by));
    }

    default void click(By by) {
        getWait().until(ExpectedConditions.presenceOfElementLocated(by));
        getWait().until(ExpectedConditions.visibilityOf(getElement(by)));
        getWait().until(ExpectedConditions.elementToBeClickable(by));
        getWait().until(ExpectedConditions.not(ExpectedConditions.stalenessOf(getElement(by))));
        getDriver().findElement(by).click();
    }

    default void sendKeys(By by, CharSequence... characters) {
        getWait().until(ExpectedConditions.presenceOfElementLocated(by));
        getWait().until(ExpectedConditions.visibilityOf(getElement(by)));
        getWait().until(ExpectedConditions.elementToBeClickable(getElement(by)));
        getWait().until(ExpectedConditions.not(ExpectedConditions.stalenessOf(getElement(by))));
        getDriver().findElement(by).sendKeys(characters);
    }

    default void clickBackButton() {
        getDriver().navigate().back();
    }

    default void clickForwardButton() {
        getDriver().navigate().forward();
    }

    default void clickRefreshButton() {
        getDriver().navigate().refresh();
    }

    default void takeScreenShot(){
        TakesScreenshot screenshot = (TakesScreenshot) getDriver();
        File screenShotFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("myfile.jpeg");
        try {
            FileUtils.copyFile(screenShotFile,destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    default void tearDown() {
//        Wait a few seconds to see results in-action or take screenshot
//        takeScreenShot();
        if (getDriver() != null)
            getDriver().quit();
    }
}
