package com.vertexinc.returns.test.cloudui.util.resources.page;

import com.vertexinc.returns.test.cloudui.util.interfaces.DriverHandlerInterface;
import com.vertexinc.returns.test.cloudui.util.interfaces.PageInterface;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface CloudLogInPageInterface<SomeDriverHandlerInterface extends DriverHandlerInterface> extends PageInterface<SomeDriverHandlerInterface> {

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

    SomeDriverHandlerInterface getDriverHandler();

}
