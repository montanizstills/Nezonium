package com.vertexinc.returns.test.cloudui;

import com.vertexinc.returns.test.cloudui.util.DriverHandler;
import com.vertexinc.returns.test.cloudui.util.Environment;
import com.vertexinc.returns.test.cloudui.util.concretepage.CloudHomePage;
import com.vertexinc.returns.test.cloudui.util.concretepage.CloudLoginPage;
import com.vertexinc.returns.test.cloudui.util.pageinterface.CloudHomePageInterface;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloudHomePageTest extends TestImpl implements CloudHomePageInterface {

    private WebDriver browser;
    private final Environment environment = Environment.DEV;
    private DriverHandler driverHandler;


    @Test
    public void Test_Click_Rates_and_Jurisdictions_Button() {
        //Given:
        String expectedUsername = "vertuser2@vertex.local";
        String expectedPassword = "u$1&pBFlyf7R";

        //Start Test by logging into cloud.
        CloudLoginPage cloudLoginPage = new CloudLoginPage(getDriverHandler());

        //When:
        WebDriverManager.chromedriver().setup();
        this.browser = new ChromeDriver();
        getDriverHandler().navigateTo(environment.getURL());

        //1.Login
        cloudLoginPage.login(expectedUsername, expectedPassword);
        CloudHomePage cloudHomePage = new CloudHomePage(getDriverHandler());
        cloudHomePage.clickRatesJurisdictionButton();

        //Then:
        Assert.assertEquals("https://devportal.vertexsmb.com/RateLookup", getDriverHandler().getCurrentUrl());

        //clean up
        getDriverHandler().tearDown();
    }

    @Test
    public synchronized void Test_Click_ECW_Logs_Button() {
        //Given:
        String expectedUsername = "vertuser2@vertex.local";
        String expectedPassword = "u$1&pBFlyf7R";


        //When:
        WebDriverManager.chromedriver().setup();
        this.browser = new ChromeDriver();

        CloudLoginPage cloudLoginPage = new CloudLoginPage(getDriverHandler());
        cloudLoginPage.login(expectedUsername, expectedPassword);
        CloudHomePage cloudHomePage = new CloudHomePage(getDriverHandler());

        //Test
        cloudHomePage.clickECWLogsButton();

        //Then:
        Assert.assertEquals("https://devportal.vertexsmb.com/Admin/BigCommerceLogs", getDriverHandler().getCurrentUrl());

        //clean up
        getDriverHandler().tearDown();
    }


    @Override
    public Environment getEnvironment() {
        return this.environment;
    }

}
