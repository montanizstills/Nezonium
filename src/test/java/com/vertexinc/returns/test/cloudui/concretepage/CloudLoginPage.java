package com.vertexinc.returns.test.cloudui.concretepage;

import com.vertexinc.returns.test.cloudui.uimap.CloudLoginPage_UIMap;
import com.vertexinc.returns.test.cloudui.util.DriverHandler;
import com.vertexinc.returns.test.cloudui.util.Page;


public class CloudLoginPage extends Page implements CloudLoginPage_UIMap {

    public CloudLoginPage(DriverHandler driverHandler) {
        super(driverHandler);
    }


    public void enterUserName(String usernameInput) {
        getDriverHandler().sendKeys(getUsernameField(), usernameInput);
    }

    public String getUserName() {
        return getDriverHandler().getElement(getUsernameField()).getText();
    }

    public String getPassword() {
        return getDriverHandler().getElement(getPasswordField()).getText();
    }

    public void login(String usernameInput, String passwordInput) {
        getDriverHandler().sendKeys(getUsernameField(), usernameInput);
        getDriverHandler().sendKeys(getPasswordField(), passwordInput);
        getDriverHandler().click(getLogInButton());
//       return new CloudHomePage(getDriverHandler());
    }

    public void enterPassword(String expectedPassword) {
        getDriverHandler().sendKeys(getPasswordField(), expectedPassword);
    }

    public void clickForgotPasswordButton() {
        getDriverHandler().click(getForgotPasswordButton());
    }
}
