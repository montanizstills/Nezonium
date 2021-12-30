//package com.vertexinc.returns.test.cloudui;
//
//import com.vertexinc.returns.test.cloudui.concretepage.CloudCommonUILoginPage;
//import com.vertexinc.returns.test.cloudui.util.DriverHandler;
//import com.vertexinc.returns.test.cloudui.util.Environment;
//import com.vertexinc.returns.test.cloudui.concretepage.CloudHomePage;
//import com.vertexinc.returns.test.cloudui.concretepage.CloudLoginPage;
//import com.vertexinc.returns.test.cloudui.uimap.CloudHomePage_UIMap;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.junit.Assert;
//import org.junit.Test;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class CloudHomePageTest implements CloudHomePage_UIMap {
//
//    private WebDriver browser;
//    private final Environment environment = Environment.QA;
//    private DriverHandler driverHandler;
//
//
//    @Test
//    public void Test_Click_Rates_and_Jurisdictions_Button() {
//        WebDriverManager.chromedriver().setup();
//        this.browser = new ChromeDriver();
//        this.driverHandler = new DriverHandler(this.browser);
//
//        //Given:
//        String expectedUsername = "vertuser2@vertex.local";
//        String expectedPassword = "u$1&pBFlyf7R";
//        //When:
//        //Start Test by logging into cloud.
//        CloudLoginPage cloudLoginPage = new CloudLoginPage(getDriverHandler());
//        cloudLoginPage.navigateTo(environment.getURL());
//        //1.Login
//        cloudLoginPage.login(expectedUsername, expectedPassword);
//        CloudHomePage cloudHomePage = new CloudHomePage(getDriverHandler());
//        cloudHomePage.clickRatesJurisdictionButton();
//        //Then:
//        Assert.assertEquals("https://devportal.vertexsmb.com/RateLookup", getDriverHandler().getCurrentUrl());
//
//        //clean up
//        getDriverHandler().tearDown();
//    }
//
//    @Test
//    public void Test_Click_ECW_Logs_Button() {
//        WebDriverManager.chromedriver().setup();
//        this.browser = new ChromeDriver();
//        this.driverHandler = new DriverHandler(this.browser);
//
//        //Given:
//        String expectedUsername = "vertuser2@vertex.local";
//        String expectedPassword = "u$1&pBFlyf7R";
//        CloudCommonUILoginPage cloudCommonUILoginPage = new CloudCommonUILoginPage(getDriverHandler());
//
//
//        CloudLoginPage cloudLoginPage = new CloudLoginPage(getDriverHandler());
//        //When:
//        cloudLoginPage.navigateTo("devportal.vertexsmb.com");
//        cloudLoginPage.login(expectedUsername, expectedPassword);
//        CloudHomePage cloudHomePage = new CloudHomePage(getDriverHandler());
//        cloudHomePage.clickECWLogsButton();
//        //Then:
//        Assert.assertEquals("https://devportal.vertexsmb.com/Admin/EcWizardLogs", cloudHomePage.getCurrentURL());
//
//        //clean up
//        getDriverHandler().tearDown();
//    }
//
//
//    @Override
//    public DriverHandler getDriverHandler() {
//        return this.driverHandler;
//    }
//}
