package com.vertexinc.returns.test.cloudui.tests;

import com.vertexinc.returns.test.cloudui.util.interfaces.TestInterface;
import com.vertexinc.returns.test.cloudui.util.resources.Environment;
import com.vertexinc.returns.test.cloudui.util.resources.page.CloudHomePageInterface;
import com.vertexinc.returns.test.cloudui.util.resources.page.CloudLogInPageInterface;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CloudHomePageTest implements CloudHomePageInterface, TestInterface {

    private WebDriver browser;
    private final Environment environment = Environment.DEV;

    @Test
    public void Test_Click_Rates_and_Jurisdictions_Button() {
        //Given:
        String expectedUsername = "vertuser2@vertex.local";
        String expectedPassword = "u$1&pBFlyf7R";

        //When:
        WebDriverManager.chromedriver().setup();
        this.browser = new ChromeDriver();
        getBrowser().navigate().to(this.environment.getURL());

        //1.Login
        By usernameField = CloudLogInPageInterface.usernameField;
        By passwordField = CloudLogInPageInterface.passwordField;
        getBrowser().findElement(usernameField).sendKeys(expectedUsername);
        getBrowser().findElement(passwordField).sendKeys(expectedPassword);
        getBrowser().findElement(CloudLogInPageInterface.loginButton).click();

        getBrowser().findElement(CloudHomePageInterface.ratesJurisdictionButton).click();

        //Then:
        Assert.assertEquals("https://devportal.vertexsmb.com/RateLookup", getBrowser().getCurrentUrl());

        //clean up
        tearDown();
    }

    @Test
    public synchronized void Test_Click_ECW_Logs_Button() {
        //Given:
        String expectedUsername = "vertuser2@vertex.local";
        String expectedPassword = "u$1&pBFlyf7R";

        //When:
        WebDriverManager.chromedriver().setup();
        this.browser = new ChromeDriver();

        getBrowser().navigate().to(this.environment.getURL());

        //1.Login
        By usernameField = CloudLogInPageInterface.usernameField;
        By passwordField = CloudLogInPageInterface.passwordField;
        getBrowser().findElement(usernameField).sendKeys(expectedUsername);
        getBrowser().findElement(passwordField).sendKeys(expectedPassword);
        getBrowser().findElement(CloudLogInPageInterface.loginButton).click();

        //Test
        Actions actions = new Actions(getBrowser());
        actions.moveToElement(getBrowser().findElement(CloudHomePageInterface.logsButton)).perform();
        browserWait(5000); //if you want to see the LogButton pop up during testing uncomment.
        getBrowser().findElement(CloudHomePageInterface.logsBigCommerceLogs).click();


        //Then:
        Assert.assertEquals("https://devportal.vertexsmb.com/Admin/BigCommerceLogs", getBrowser().getCurrentUrl());

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
}
