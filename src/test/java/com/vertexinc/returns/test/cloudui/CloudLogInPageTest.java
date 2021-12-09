package com.vertexinc.returns.test.cloudui;

import com.vertexinc.returns.test.cloudui.util.DriverHandler;
import com.vertexinc.returns.test.cloudui.util.Environment;
import com.vertexinc.returns.test.cloudui.util.concretepage.CloudLoginPage;
import com.vertexinc.returns.test.cloudui.util.pageinterface.CloudLogInPageInterface;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloudLogInPageTest extends TestImpl implements
        CloudLogInPageInterface {

    private final Environment environment = Environment.DEV;
    private DriverHandler driverHandler;
    private WebDriver browser;


    @Test
    public void Test_EnterUsernameField() {
        WebDriverManager.chromedriver().setup();
        this.browser = new ChromeDriver();
        this.driverHandler = new DriverHandler(this.browser);


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

        //clean up
        getDriverHandler().tearDown();
    }

    @Test
    public void Test_EnterPasswordField() {
        WebDriverManager.chromedriver().setup();
        this.browser = new ChromeDriver();
        this.driverHandler = new DriverHandler(this.browser);

        //Given:
        String expectedPassword = "u$1&pBFlyf7R";

        //When:
        getDriverHandler().navigateTo(this.environment.getURL());
        getDriverHandler().sendKeys(getPasswordField(), expectedPassword);

        //Then:
        String actualPassword = getDriverHandler().getText(getPasswordField());
        Assert.assertEquals(expectedPassword, actualPassword);


        getDriverHandler().tearDown();
    }

    @Test
    public void Test_SuccessfulLogin() {
        WebDriverManager.chromedriver().setup();
        this.browser = new ChromeDriver();
        this.driverHandler = new DriverHandler(this.browser);

        //Given:
        String expectedUrl = "https://devportal.vertexsmb.com/Admin/AdminDash";

        //When:
        getDriverHandler().navigateTo(environment.getURL());
        getDriverHandler().sendKeys(getUsernameField(), "vertuser2@vertex.local");
        getDriverHandler().sendKeys(getPasswordField(), "u$1&pBFlyf7R");
        getDriverHandler().click(getLogInButton());

        //Then:
        String currentUrl = getDriverHandler().getCurrentUrl();
        Assert.assertEquals(expectedUrl, currentUrl);
        getDriverHandler().tearDown();
    }

    @Test
    public void Test_Forgot_Password_Test() {
        WebDriverManager.chromedriver().setup();
        this.browser = new ChromeDriver();
        this.driverHandler = new DriverHandler(this.browser);

        //Given:
        String expectedURL = "https://devauth.vertexsmb.com/forgot-password";
        CloudLoginPage cloudLoginPage = new CloudLoginPage(getDriverHandler());
        cloudLoginPage.navigateTo(getEnvironment());

        //When:
        getDriverHandler().click(getForgotPasswordButton());

        String actualURL = cloudLoginPage.getCurrentURL();
        Assert.assertEquals(expectedURL,actualURL);

        //then
        getDriverHandler().tearDown();

    }

//Inherited functions:

    @Override
    public Environment getEnvironment() {
        return this.environment;
    }

    @Override
    public DriverHandler getDriverHandler() {
        return this.driverHandler;
    }

}
