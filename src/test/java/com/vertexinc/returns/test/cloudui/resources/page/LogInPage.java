package com.vertexinc.returns.test.cloudui.resources.page;

import com.vertexinc.returns.test.cloudui.resources.Environment;
import com.vertexinc.returns.test.cloudui.util.interfaces.LogInPageInterface;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage implements LogInPageInterface {

    private WebDriver browser;
    private Environment environment;

    @Override
    public void click(By webElement) {
        LogInPageInterface.super.click(webElement);
    }

    @Override
    public void fillUsernameField(String keys) {
        LogInPageInterface.super.fillUsernameField(keys);
    }

    @Override
    public void fillPasswordField(String keys) {
        LogInPageInterface.super.fillPasswordField(keys);
    }


    @Override
    public Environment getEnv() {
        return this.environment;
    }


    @Override
    public WebDriver getBrowser() {
        return this.browser;
    }

    @Override
    public void tearDown() {
        LogInPageInterface.super.tearDown();
    }
}
