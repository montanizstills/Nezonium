package com.vertexinc.returns.test.cloudui.util.interfaces;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


public interface TestInterface {

    WebDriverManager getWebDriverManager();

    Object getExpected();

    Object getActual();

    WebDriver getBrowser();

    @After
    default void tearDown() {
        getBrowser().quit();
    }

    default void setUp() {
    getWebDriverManager().setup();
    }
}
