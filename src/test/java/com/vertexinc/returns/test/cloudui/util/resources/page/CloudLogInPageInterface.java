package com.vertexinc.returns.test.cloudui.util.resources.page;

import com.vertexinc.returns.test.cloudui.util.interfaces.PageInterface;
import org.openqa.selenium.By;

public interface CloudLogInPageInterface extends PageInterface {

    By usernameField = By.id("username");
    By passwordField = By.id("password");
    By loginButton = By.tagName("button");

    default void fillUsernameField(String keys) {
        getBrowser().findElement(usernameField).sendKeys(keys);
    }

    default void fillPasswordField(String keys) {
        getBrowser().findElement(passwordField).sendKeys(keys);
    }

    default By getLogInButton() {
        return this.loginButton;
    }

}
