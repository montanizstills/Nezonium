package com.vertexinc.returns.test.cloudui.util.pageinterface;

import com.vertexinc.returns.test.cloudui.util.DriverHandler;
import com.vertexinc.returns.test.cloudui.util.DriverHandlerInterface;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public interface CloudLogInPageInterface {

    DriverHandler getDriverHandler(); //to expose the driverHandler to implementing subclasses

    default By getLogInButton() {
        return By.tagName("button");
    }
    default  By getUsernameField(){
        return By.id("username");
    }
    default By getPasswordField(){
        return By.id("password");
    }
    default  By getForgotPasswordButton(){
        return By.cssSelector("a[href='/forgot-password']");
    }


}
