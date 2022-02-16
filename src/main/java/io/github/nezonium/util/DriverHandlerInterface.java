package io.github.nezonium.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

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


    default void tearDown() {
        if (getDriver() != null)
            getDriver().quit();
    }

    default void destroyDriver(){
        this.tearDown();
    };
}
