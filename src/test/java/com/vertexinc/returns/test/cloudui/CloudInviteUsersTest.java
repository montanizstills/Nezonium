package com.vertexinc.returns.test.cloudui;

import com.vertexinc.returns.test.cloudui.util.DriverHandler;
import com.vertexinc.returns.test.cloudui.util.Environment;
import com.vertexinc.returns.test.cloudui.util.concretepage.CloudHomePage;
import com.vertexinc.returns.test.cloudui.util.concretepage.CloudInviteUsersPage;
import com.vertexinc.returns.test.cloudui.util.concretepage.CloudLoginPage;
import com.vertexinc.returns.test.cloudui.util.pageinterface.CloudInviteUsersPageInterface;
import com.vertexinc.returns.test.cloudui.util.pageinterface.TestInterface;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloudInviteUsersTest implements CloudInviteUsersPageInterface, TestInterface {

    private WebDriver browser;
    private Environment environment = Environment.DEV;
    private DriverHandler driverHandler;


    @Test
    public void Test_StandardUserNoEditCompanyConfiguration() {
        //Given:
        //Some user who can already log into system.
        String expectedUsername = "vertuser2@vertex.local";
        String expectedPassword = "u$1&pBFlyf7R";
        String expectedNull = "Abc123";

        //When:
        WebDriverManager.chromedriver().setup();
        this.browser = new ChromeDriver();
        this.driverHandler = new DriverHandler(this.browser);

        //Create Login Page object for method reference:
        CloudLoginPage cloudLoginPage = new CloudLoginPage(getDriverHandler());

        //Go to login page
        cloudLoginPage.navigateTo(getEnvironment());

        //Login
        cloudLoginPage.login(expectedUsername, expectedPassword);

        //Create CloudHomePageObject for method reference
        CloudHomePage cloudHomePage = new CloudHomePage(driverHandler);

        //Navigate to Invite Users - Left navigation bar
        cloudHomePage.clickInviteUsers();

        CloudInviteUsersPage cloudInviteUsersPage = new CloudInviteUsersPage(getDriverHandler());

        //Click Invite Users button on Invite users page
        cloudInviteUsersPage.clickInviteUsersButton();


        //Test_SendKeysTo_OraclePartyNumberField
        WebElement oraclePartyNumber = getDriverHandler().getDriver().findElement(CloudInviteUsersPageInterface.oraclePartyNumber);
        oraclePartyNumber.sendKeys(expectedNull);
        String actual = oraclePartyNumber.getText();

        //Then:
        Assert.assertEquals(actual, expectedNull);
    }

    @Override
    public Environment getEnvironment() {
        return this.environment;
    }

    @Override
    public DriverHandler getDriverHandler() {
        return this.driverHandler;
    }
}
