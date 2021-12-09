package com.vertexinc.returns.test.cloudui;

import com.vertexinc.returns.test.cloudui.util.DriverHandler;
import com.vertexinc.returns.test.cloudui.util.Environment;
import com.vertexinc.returns.test.cloudui.util.concretepage.CloudLoginPage;
import com.vertexinc.returns.test.cloudui.util.pageinterface.CloudLogInPageInterface;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloudLogInPageTest extends TestImpl implements
        CloudLogInPageInterface{

    private final Environment environment = Environment.QA;
    private DriverHandler driverHandler;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        this.driverHandler = new DriverHandler(new ChromeDriver());
    }

    @Test
    public void testEnterUserNameField() {
        // given
        String expectedUsername = "vertuser2@vertex.local";
        CloudLoginPage cloudLogInPage = new CloudLoginPage(driverHandler);
        cloudLogInPage.navigateTo(environment);


        //When:
        cloudLogInPage.enterUserName(expectedUsername);
        String actualUsername = cloudLogInPage.getUserName();

        // then:
        Assert.assertEquals(expectedUsername, actualUsername);
    }

    @Test
    public void Test_EnterUsernameField() {
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
        //getDriverHandler().tearDown();
    }

    @Test
    public void Test_EnterPasswordField() {
        //Given:
        String expectedPassword = "u$1&pBFlyf7R";

        //When:
        getDriverHandler().navigateTo(this.environment.getURL());
        getDriverHandler().sendKeys(getPasswordField(), expectedPassword);

        //Then:
        String actualPassword = getDriverHandler().getText(getPasswordField());
        Assert.assertEquals(expectedPassword, actualPassword);

        //clean up
        getDriverHandler().tearDown();
    }

    @Test
    public void Test_SuccessfulLogin() {
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
    }

    @Test
    public void Test_Forgot_Password_Test() {
        //Given:
        getDriverHandler().navigateTo("https://devportal.vertexsmb.com");

        //When:
        getDriverHandler().click(getForgotPasswordButton());

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
