package com.vertexinc.returns.test.cloudui;

import com.vertexinc.returns.test.cloudui.util.DriverHandler;
import com.vertexinc.returns.test.cloudui.util.Environment;
import com.vertexinc.returns.test.cloudui.util.concretepage.CloudHomePage;
import com.vertexinc.returns.test.cloudui.util.concretepage.CloudInviteUsersPage;
import com.vertexinc.returns.test.cloudui.util.concretepage.CloudLoginPage;
import com.vertexinc.returns.test.cloudui.util.pageinterface.CloudInviteUsersPageInterface;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloudInviteUsersTest implements CloudInviteUsersPageInterface{

    private WebDriver browser;
    private Environment environment = Environment.DEV;
    private DriverHandler driverHandler;


    @Test
    public void Test_StandardUserNoEditCompanyConfiguration() {
        WebDriverManager.chromedriver().setup();
        this.browser = new ChromeDriver();
        this.driverHandler = new DriverHandler(this.browser);

        //Given:
        //Some user who can already log into system.
        String expectedUsername = "vertuser2@vertex.local";
        String expectedPassword = "u$1&pBFlyf7R";
        String oraclePartyNumber = "Abc123";

        //When:
        //Create Login Page object for method reference:
        CloudLoginPage cloudLoginPage = new CloudLoginPage(getDriverHandler());
        //Go to login page
        cloudLoginPage.navigateTo(environment);
        //Login
        cloudLoginPage.login(expectedUsername, expectedPassword);
        //Create CloudHomePageObject for method reference
        CloudHomePage cloudHomePage = new CloudHomePage(getDriverHandler());
        //Navigate to Invite Users - Left navigation bar
        cloudHomePage.clickInviteUsers();
        //New SPA, new object...
        CloudInviteUsersPage cloudInviteUsersPage = new CloudInviteUsersPage(getDriverHandler());
        //Click Invite Users button on Invite users page
        cloudInviteUsersPage.clickInviteUsersButton(); //if web element had an Id -- this would remove extra code needed to find element. Bridges gap between front end and testers


        //Test_SendKeysTo_OraclePartyNumberField
        cloudInviteUsersPage.enterOraclePartyNumber(oraclePartyNumber);
        String actual = cloudInviteUsersPage.getOraclePartyNumber();

        //Then:
        Assert.assertEquals(actual, oraclePartyNumber);
    }

    @Override
    public DriverHandler getDriverHandler() {
        return this.driverHandler;
    }
}
