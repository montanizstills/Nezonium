package com.vertexinc.returns.test.cloudui.util.pageinterface;

import com.vertexinc.returns.test.cloudui.util.DriverHandler;
import org.openqa.selenium.By;

public interface CloudLogInPageInterface extends PageInterface {

    DriverHandler getDriverHandler();

    default By getLogInButton() {
        return By.tagName("button");
    }

    default By getUsernameField() {
        return By.id("username");
    }

    default By getPasswordField() {
        return By.id("password");
    }

    default By getForgotPasswordButton() {
        return By.cssSelector("a[href='/forgot-password']");
    }

}

