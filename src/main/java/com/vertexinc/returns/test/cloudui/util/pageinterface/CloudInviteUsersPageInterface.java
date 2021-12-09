package com.vertexinc.returns.test.cloudui.util.pageinterface;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

//Prior to time has existed vs Expected after some time has passed = Interface vs Class
//By is a way to select element on a page
//WebElement = actual element on page.
public interface CloudInviteUsersPageInterface extends PageInterface {

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
    default By getOraclePartyNumberField() {
        return By.cssSelector("input[name='OraclePartyNumber']");
    }
}
