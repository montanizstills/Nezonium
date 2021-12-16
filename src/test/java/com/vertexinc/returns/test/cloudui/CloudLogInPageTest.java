package com.vertexinc.returns.test.cloudui;

import com.vertexinc.returns.test.cloudui.util.DriverHandler;
import com.vertexinc.returns.test.cloudui.util.Environment;
import com.vertexinc.returns.test.cloudui.concretepage.CloudLoginPage;
import com.vertexinc.returns.test.cloudui.uimap.CloudLoginPage_UIMap;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloudLogInPageTest implements CloudLoginPage_UIMap {

    private final Environment environment = Environment.QA;
    private DriverHandler driverHandler;
    private WebDriver browser;


    @Test
    public void Test_EnterUsernameField() {
        //Setup
        WebDriverManager.chromedriver().setup();
        this.browser = new ChromeDriver();
        this.driverHandler = new DriverHandler(this.browser);

        //End Setup

        //Test:
        //Given:
        String expectedUsername = "vertuser2@vertex.local";
        CloudLoginPage cloudLogInPage = new CloudLoginPage(driverHandler);
        //LoginPage object for method invocation
        cloudLogInPage.navigateTo(environment);
        //When:
        cloudLogInPage.enterUserName(expectedUsername);
        //Then:
        //we can directly ask the object to return some values after work has been done.
        String actualUsername = cloudLogInPage.getUserName();
        Assert.assertEquals(expectedUsername, actualUsername);
        //End Test

        //Clean up
        getDriverHandler().tearDown();
    }

    @Test
    public void Test_EnterPasswordField() {
        //Setup:
        WebDriverManager.chromedriver().setup();
        this.browser = new ChromeDriver();
        this.driverHandler = new DriverHandler(this.browser);
        //End Setup

        //Test:
        //Given:
        String expectedPassword = "u$1&pBFlyf7R";
        CloudLoginPage cloudLoginPage = new CloudLoginPage(getDriverHandler());
        //When:
        cloudLoginPage.navigateTo(environment);
        cloudLoginPage.enterPassword(expectedPassword);
        //Then:
        String actualPassword = cloudLoginPage.getPassword();
        Assert.assertEquals(expectedPassword, actualPassword);
        //End Test

        //Clean Up
        getDriverHandler().tearDown();
    }

    @Test
    public void Test_SuccessfulLogin() {
        //Setup:
        WebDriverManager.chromedriver().setup();
        this.browser = new ChromeDriver();
        this.driverHandler = new DriverHandler(this.browser);
        //End Setup

        //Test:
        //Given:
        String expectedUsername = "vertuser2@vertex.local";
        String expectedPassword = "u$1&pBFlyf7R";
        String expectedUrl = "https://devportal.vertexsmb.com/Admin/AdminDash";
        CloudLoginPage cloudLoginPage = new CloudLoginPage(getDriverHandler());
        //When:
        cloudLoginPage.navigateTo(environment);
        cloudLoginPage.login(expectedUsername, expectedPassword);
        //Then:
        String actualURL = cloudLoginPage.getCurrentURL();
        Assert.assertEquals(expectedUrl, actualURL);
        //End Test

        //Clean up
        getDriverHandler().tearDown();
    }

    @Test
    public void Test_Forgot_Password_Test() {
        //Setup:
        WebDriverManager.chromedriver().setup();
        this.browser = new ChromeDriver();
        this.driverHandler = new DriverHandler(this.browser);
        //End Setup

        //Test
        //Given:
        String expectedURL = "https://devauth.vertexsmb.com/forgot-password";
        CloudLoginPage cloudLoginPage = new CloudLoginPage(getDriverHandler());
        cloudLoginPage.navigateTo(environment);
        //When:
        cloudLoginPage.clickForgotPasswordButton();
        String actualURL = cloudLoginPage.getCurrentURL();
        //Then:
        Assert.assertEquals(expectedURL, actualURL);
        //End Test

        //Clean up
        getDriverHandler().tearDown();

    }

    @Override
    public DriverHandler getDriverHandler() {
        return this.driverHandler;
    }

}
