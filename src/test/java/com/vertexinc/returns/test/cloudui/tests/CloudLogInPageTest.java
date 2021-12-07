package com.vertexinc.returns.test.cloudui.tests;

import com.vertexinc.returns.test.cloudui.util.interfaces.TestInterface;
import com.vertexinc.returns.test.cloudui.util.resources.Environment;
import com.vertexinc.returns.test.cloudui.util.resources.page.CloudLogInPageInterface;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

public class CloudLogInPageTest implements CloudLogInPageInterface, TestInterface {

    private WebDriver browser;
    private final Environment environment = Environment.QA;


    @Test
    public void Test_EnterUsernameField() {
        //Given:
        String expectedUsername = "vertuser2@vertex.local";

        //When:
        WebDriverManager.chromedriver().setup();
        this.browser = new ChromeDriver();
        getBrowser().navigate().to(this.environment.getURL());
        fillUsernameField(expectedUsername);

        //Then:
        browserWait(5000);
        String actualUsername = getBrowser().findElement(usernameField).getText();
        Assert.assertEquals(expectedUsername, actualUsername);

        //clean up
        tearDown();
    }

    @Test
    public void Test_EnterPasswordField() {
        //Given:
        String expectedPassword = "u$1&pBFlyf7R";

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

    @Test
    public void Test_Forgot_Password_Test(){
        //Given:
        //NONE; nothing is needed for this test.

        //When:
        WebDriverManager.chromedriver().setup();
        this.browser = new ChromeDriver();
        getBrowser().navigate().to("https://devportal.vertexsmb.com");

        //Then:
        getBrowser().findElement(CloudLogInPageTest.forgotPasswordButton).click();

        //clean up
        tearDown();

    }


    @Override
    public WebDriver getBrowser() {
        return this.browser;
    }

    @Override
    public Environment getEnvironment() {
        return this.environment;
    }

    @Override
    public FluentWait<WebDriver> getWaitDriver() {
        return new FluentWait<>(getBrowser());
    }

    @Override
    public synchronized void browserWait(int milliseconds) {
        TestInterface.super.browserWait(milliseconds);
    }
}
