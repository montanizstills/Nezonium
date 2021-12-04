package com.vertexinc.returns.test.cloudui.util.interfaces;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public interface PageInterface {

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

    default void click(By webElement) {
        getBrowser().findElement(webElement).click();
    }

//    @After annotation through inheritance not working to expectation
//    explicitly calling as workaround.
    default void tearDown() {
        if (getBrowser() != null)
            getBrowser().quit();
    }

}
