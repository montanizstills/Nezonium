package com.vertexinc.returns.test.cloudui.tests;

import com.vertexinc.returns.test.cloudui.resources.Environment;
import com.vertexinc.returns.test.cloudui.resources.page.LogInPage;
import com.vertexinc.returns.test.cloudui.util.interfaces.LogInPageInterface;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogInPageTest extends LogInPage {

    private WebDriver browser;
    private Environment environment;


    @Test
    public void Test_EnterUsernameField() {
        //Given:
        String expectedUsername = "vertuser2@vertex.local";
        this.environment = Environment.QA;


        //When:
        WebDriverManager.chromedriver().setup();
        this.browser = new ChromeDriver();
        getBrowser().navigate().to(this.environment.getURL());
        fillUsernameField(expectedUsername);

        //Then:
        String actualUsername = getBrowser().findElement(usernameField).getText();
        Assert.assertEquals(expectedUsername, actualUsername);


        //clean up
        tearDown();
    }

    @Test
    public void Test_EnterPasswordField() {
        //Given:
        String expectedPassword = "u$1&pBFlyf7R";
        this.environment = Environment.QA;

        //When:
        WebDriverManager.chromedriver().setup();
        this.browser = new ChromeDriver();
        getBrowser().navigate().to(this.environment.getURL());
        fillPasswordField(expectedPassword);

        //Then:
        String actualPassword = getBrowser().findElement(passwordField).getText();
        Assert.assertEquals(expectedPassword, actualPassword);

        //clean up
        tearDown();
    }

    @Test
    public void Test_SuccessfulLogin() {
        //Given:
        String expectedUsername = "vertuser2@vertex.local";
        String expectedPassword = "u$1&pBFlyf7R";
        this.environment = Environment.QA;

        //When:
        WebDriverManager.chromedriver().setup();
        this.browser = new ChromeDriver();
        getBrowser().navigate().to(environment.getURL());
        fillUsernameField(expectedUsername);
        fillPasswordField(expectedPassword);
        click(getLogInButton());

        //Then:
        Assert.assertEquals("https://devportal.vertexsmb.com/Admin/AdminDash", getBrowser().getCurrentUrl());

        //clean up
        tearDown();
    }

}
