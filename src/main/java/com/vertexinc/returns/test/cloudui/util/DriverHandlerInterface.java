package com.vertexinc.returns.test.cloudui.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

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

    default WebElement getElementByAttribute(By by, String attribute, String attributeValue) {
        WebElement webElement = getDriver().findElement(by);
        return getDriver().findElement(By.cssSelector(webElement.getTagName() + "['" + attribute + "=" + attributeValue + "']"));
    }

    default void navigateTo(String url) {
        getDriver().navigate().to(url);
    }

    default void click(By by) {
        WebElement webElement = getDriver().findElement(by);
        getWait().until(ExpectedConditions.presenceOfElementLocated(by));
        getWait().until(ExpectedConditions.visibilityOf(webElement));
        getWait().until(ExpectedConditions.elementToBeClickable(webElement));
        getDriver().findElement(by).click();
    }

    default void sendKeys(By by, CharSequence... characters) {
        WebElement we = getDriver().findElement(by);
        getWait().until(ExpectedConditions.presenceOfElementLocated(by));
        getWait().until(ExpectedConditions.visibilityOf(we));
        getWait().until(ExpectedConditions.elementToBeClickable(we));
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

    default void tearDown() {
//        Wait a few seconds to see results in-action or take screenshot
//        takeScreenShot();
        if (getDriver() != null)
            getDriver().quit();
    }
}
