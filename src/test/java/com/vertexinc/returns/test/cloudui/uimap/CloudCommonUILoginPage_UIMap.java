package com.vertexinc.returns.test.cloudui.uimap;

import org.openqa.selenium.By;

public interface CloudCommonUILoginPage_UIMap {

    default By getUsernameField(){
        return  By.id("username");
    }
    default By getContinueButton(){
        return By.cssSelector("button[name='action']");
    }
    default By getPasswordField(){
        return By.id("password");
    }
    default By getForgotPasswordButton(){
        return By.cssSelector("a[href*='reset-password']");
    }
    default By getEditButton(){
        return By.cssSelector("a[data-link-name='edit-username']");
    }
}
