package com.vertexinc.returns.test.cloudui;

import com.vertexinc.returns.test.cloudui.util.interfaces.TestInterface;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyTest {

    @Test
    public void Test01() {

        //Given:
        String expected = "https://www.vertexinc.com/";
        WebDriver browser;

        //When:
//        WebDriverManager.chromedriver().setup();
//        browser = new ChromeDriver();

        browser = Browsers.FIREFOX.getInstance();

        browser.get("https://www.vertexinc.com");

        String actual = browser.getCurrentUrl();


        //Then:
        Assert.assertEquals(expected, actual);
    }


}
