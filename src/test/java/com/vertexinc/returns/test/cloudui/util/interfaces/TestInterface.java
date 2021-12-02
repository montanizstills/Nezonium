package com.vertexinc.returns.test.cloudui.util.interfaces;

import com.vertexinc.returns.test.cloudui.resources.Environment;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public interface TestInterface {

    Environment getEnvironment();
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

    default void tearDown() {
        if (getBrowser() != null)
            getBrowser().quit();
    }

}
