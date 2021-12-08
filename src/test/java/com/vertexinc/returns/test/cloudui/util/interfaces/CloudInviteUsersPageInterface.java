package com.vertexinc.returns.test.cloudui.util.resources.page;

import com.vertexinc.returns.test.cloudui.util.interfaces.PageInterface;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

//Prior to time has existed vs Expected after some time has passed = Interface vs Class
//By is a way to select element on a page
//WebElement = actual element on page.
public interface CloudInviteUsersPageInterface extends PageInterface{
//    By inviteUsersButton = new FluentWait<WebDriver>(getBrowser()).
//            until(ExpectedConditions.visibilityOf(getBrowser()
//                    .findElement(By.cssSelector("a[href='#/inviteNew']"))));


    By oraclePartyNumber = By.cssSelector("input[name='OraclePartyNumber']");

    default By getInviteUsersButton() {

        return By.cssSelector("a[href='#/inviteNew']");

    }

    default By getEmailField() {
        return By.id("Email");
    }

    default Select getRole_HTMLObject() {
        return null;//todo
    }

    //Customer Admin
    default Select getAccountType_HTMLObject() {
        return null;//todo
    }


    default Select getVarCPAFranchiseName_HTMLObject() {
        return null;//todo
    }

    // Customer Admin
    default By getOraclePartyNumber() {
        return By.cssSelector("input[name='OraclePartyNumber']");
    }
}
