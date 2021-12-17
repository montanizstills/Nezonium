package com.vertexinc.returns.test.cloudui;

import com.vertexinc.returns.test.cloudui.util.DriverHandler;
import com.vertexinc.returns.test.cloudui.util.Environment;
import com.vertexinc.returns.test.cloudui.concretepage.CloudHomePage;
import com.vertexinc.returns.test.cloudui.concretepage.CloudInviteUsersPage;
import com.vertexinc.returns.test.cloudui.concretepage.CloudLoginPage;
import com.vertexinc.returns.test.cloudui.uimap.CloudInviteUsersPage_UIMap;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloudInviteUsersTest implements CloudInviteUsersPage_UIMap {

    private WebDriver browser;
    private Environment environment = Environment.QA;
    private DriverHandler driverHandler;


    @Test
    public void Test_StandardUserNoEditCompanyConfiguration() {
        WebDriverManager.chromedriver().setup();
        this.browser = new ChromeDriver();
        this.driverHandler = new DriverHandler(this.browser);

        //Given:
        //Some user who can already log into system.
        String expectedUsername = environment.getUsername();
        String expectedPassword = environment.getPassword();
        String expectedOraclePartyNumber = "123456";

        //When:
        //Create Login Page object for method reference:
        CloudLoginPage cloudLoginPage = new CloudLoginPage(getDriverHandler());
        //Go to login page
        cloudLoginPage.navigateTo(environment.getURL());
        //Login
        cloudLoginPage.login(expectedUsername, expectedPassword);
        //Create CloudHomePageObject for method reference
        CloudHomePage cloudHomePage = new CloudHomePage(getDriverHandler());
        //Navigate to Invite Users - Left navigation bar
        cloudHomePage.clickInviteUsers();
        //New SPA, new object...
        CloudInviteUsersPage cloudInviteUsersPage = new CloudInviteUsersPage(getDriverHandler());
        //Click Invite Users button on Invite users page
        cloudInviteUsersPage.clickInviteUsersButton();
        cloudInviteUsersPage.getDriverHandler().toSelect(getRole_SelectElement());
        cloudInviteUsersPage.setRoleValue("Customer Admin");
        cloudInviteUsersPage.enterOraclePartyNumber(expectedOraclePartyNumber);
        String actual = cloudInviteUsersPage.getOraclePartyNumber();

        //Then:
        Assert.assertEquals(expectedOraclePartyNumber, actual);
    }

    @After
    public void cleanUp(){
        getDriverHandler().tearDown();
    }

    @Override
    public DriverHandler getDriverHandler() {
        return this.driverHandler;
    }
}
