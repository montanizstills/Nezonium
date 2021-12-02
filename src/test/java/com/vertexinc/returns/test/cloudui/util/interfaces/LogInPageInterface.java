package com.vertexinc.returns.test.cloudui.util.interfaces;

import com.vertexinc.returns.test.cloudui.resources.Environment;
import org.openqa.selenium.By;

public interface LogInPageInterface extends TestInterface{

    By usernameField = By.id("username");
    By passwordField = By.id("password");
    By loginButton = By.tagName("button");

default  void fillUsernameField(String keys){
   getBrowser().findElement(usernameField).sendKeys(keys);
}
default void fillPasswordField(String keys){
    getBrowser().findElement(passwordField).sendKeys(keys);
}

Environment getEnv();

default By getLogInButton(){
    return this.loginButton;
}
    @Override
    default void click(By webElement) {
        TestInterface.super.click(webElement);
    }
}
