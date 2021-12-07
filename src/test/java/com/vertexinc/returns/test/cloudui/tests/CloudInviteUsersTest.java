package com.vertexinc.returns.test.cloudui.tests;

import com.vertexinc.returns.test.cloudui.util.interfaces.TestInterface;
import com.vertexinc.returns.test.cloudui.util.resources.Environment;
import com.vertexinc.returns.test.cloudui.util.resources.page.CloudHomePageInterface;
import com.vertexinc.returns.test.cloudui.util.resources.page.CloudInviteUsersPageInterface;
import com.vertexinc.returns.test.cloudui.util.resources.page.CloudLogInPageInterface;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class CloudInviteUsersTest implements CloudInviteUsersPageInterface, TestInterface {

    private WebDriver browser;
    private Environment environment = Environment.DEV;
    private String roleSelectObjectValue;

    @Test
    public void Test_StandardUserNoEditCompanyConfiguration() {
        //Given:
        //Some user who can already log into system.
        String expectedUsername = "vertuser2@vertex.local";
        String password = "u$1&pBFlyf7R";
        String expected = "Abc123";

        //When:
        WebDriverManager.chromedriver().setup();
        this.browser = new ChromeDriver();

        //Go to login page
        getBrowser().navigate().to(this.environment.getURL());

        //Login
        WebElement usernameField = getBrowser().findElement(CloudLogInPageInterface.usernameField);
        usernameField.sendKeys(expectedUsername);

        WebElement passwordField = getBrowser().findElement(CloudLogInPageInterface.passwordField);
        passwordField.sendKeys(password);

        getBrowser().findElement(CloudLogInPageInterface.loginButton).click();

        //Navigate to Invite Users - Left navigation bar
        click(CloudHomePageInterface.inviteUsersButton);

        //wait until invite users button appears
        //getWaitDriver().until(ExpectedConditions.visibilityOf(getBrowser().findElement(CloudInviteUsersTest.inviteUsersButton)));
        WebElement inviteUsersButton = getWaitDriver().until(ExpectedConditions.visibilityOf(getBrowser().findElement(CloudInviteUsersPageInterface.inviteUsersButton)));
        inviteUsersButton.click();

        //Click Invite Users button on Invite users page
        click(CloudInviteUsersPageInterface.inviteUsersButton);

        //wait until object (InviteUsers form) is loaded
        /*
        would like to express as, below:
        wait.until(ExpectedConditions.visibilityOf(getBrowser().findElement(CloudInviteUsersPageInterface.oraclePartyNumber)));

        however, the following is a cleaner expression:
        getWaitDriver(getBrowser()).until(ExpectedConditions.visibilityOf(getBrowser().findElement(CloudInviteUsersPageInterface.oraclePartyNumber)));
        */

        getWaitDriver().until(ExpectedConditions.visibilityOf(getBrowser().findElement(CloudInviteUsersPageInterface.oraclePartyNumber)));



        //Test_SendKeysTo_OraclePartyNumberField
        WebElement oraclePartyNumber = getBrowser().findElement(CloudInviteUsersPageInterface.oraclePartyNumber);
        oraclePartyNumber.sendKeys(expected);
        browserWait(7000);
        String actual = oraclePartyNumber.getText();

        //Then:
        Assert.assertEquals(actual, expected);
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
    public String getRole_HTMLSelectObjectValue() {
        return this.roleSelectObjectValue;
    }

    @Override
    public void setRole_HTMLSelectObjectValue(String roleSelectObjectValue) {
        this.roleSelectObjectValue = roleSelectObjectValue;
    }
}
