package com.vertexinc.returns.test.cloudui.util.resources.page;

import com.vertexinc.returns.test.cloudui.util.interfaces.PageInterface;
import com.vertexinc.returns.test.cloudui.util.interfaces.TestInterface;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public interface CloudInviteUsersPageInterface extends PageInterface {
    By inviteUsersButton = By.cssSelector("a[href='#/inviteNew']");
    Select role_HTMLObject = null;

    String getRole_HTMLSelectObjectValue();

    void setRole_HTMLSelectObjectValue(String roleSelectObjectValue);

    //Customer Admin
    Select accountType_HTMLObject = null;
    Select varCPAFranchiseName_HTMLObject = null;
    By oraclePartyNumber = By.cssSelector("input[name='OraclePartyNumber']");

    By emailField = By.id("Email");
}
