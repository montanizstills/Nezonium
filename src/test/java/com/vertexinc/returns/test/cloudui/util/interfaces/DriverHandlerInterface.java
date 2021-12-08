package com.vertexinc.returns.test.cloudui.util.resources;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;


public interface DriverHandlerInterface<SomeDriver extends WebDriver> {

    SomeDriver getDriver();

    FluentWait<SomeDriver> getWait();


    default void click(By by) {
        WebElement webElement = getDriver().findElement(by);
        getWait().until(ExpectedConditions.presenceOfElementLocated(by));
        getWait().until(ExpectedConditions.visibilityOf(webElement));
        getWait().until(ExpectedConditions.elementToBeClickable(webElement));
        getDriver().findElement(by).click();
    }

//    default void sendKeys(By by, CharSequence... characters) {
//        WebElement we = getDriver().findElement(by);
//        getWait().until(ExpectedConditions.presenceOfElementLocated(by));
//        getWait().until(ExpectedConditions.visibilityOf(we));
//        getWait().until(ExpectedConditions.elementToBeClickable(we));
//        getDriver().findElement(by).sendKeys(characters);
//    }


//    FluentWait<WebDriver> getWaitDriver();

    WebDriver getBrowser();

    default void clickBackButton() {
        getBrowser().navigate().back();
    }

    default void clickForwardButton() {
        getBrowser().navigate().forward();
    }

    default void clickRefreshButton() {
        getBrowser().navigate().refresh();
    }


    /*
        @After annotation through inheritance not working to expectation
    //    default void tearDown()
    //    explicitly calling as workaround.
        */
    default void tearDown() {
//        Wait a few seconds to see results in-action or take screenshot
//        takeScreenShot();

        if (getBrowser() != null)
            getBrowser().quit();
    }
}
