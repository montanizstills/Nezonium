package com.vertexinc.returns.test.cloudui.uimap;

import com.vertexinc.returns.test.cloudui.util.PageInterface;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public interface CloudInviteUsersPage_UIMap extends PageInterface {

    default By getInviteUsersButton() {
        return By.cssSelector("a[href='#/inviteNew']");
    }


    default By getRole_SelectElement(){
        return By.cssSelector("select[name='Role']");
    }

    default By getEmailField() {
        return By.id("Email");
    }


    //Customer Admin
    default By getAccountType_HTMLObject() {
        return   By.cssSelector("select[name='clientSubTypeName']");
    }

    default By getVarCPAFranchiseName_HTMLObject() {
        return  By.cssSelector("select[name='resellerName']");  
    }

    default By getOraclePartyNumberField() {
        return By.cssSelector("input[name='OraclePartyNumber']");
    }

    default By getClientName_Object() {
        return By.cssSelector("input[name='ClientName']");   
    }

    default By getCountry_HTMLObject() {
        return  By.cssSelector("select[name='Country']");   
    }

    default By getStreetAddressField() {
        return By.cssSelector("input[name='Address1']");  
    }

    default By getStreetAddress2Field() {
        return By.cssSelector("input[name='Address2']");  
    }

    default By getCityField() {
        return By.cssSelector("input[name='City']");  
    }

    default By getState_HTMLObject() {
        return  By.cssSelector("select[name='StateCode']");   
    }

    default By getZipPostalCodeField() {
        return By.cssSelector("input[name='PostalCode']");   
    }

    default By getSubscription_HTMLObject() {

        return  By.cssSelector("select[name='subscriptionId']");   
    }

    default By getReservedPod_CheckBox() {
        return By.cssSelector("input[name='isReservedPodChecked']");   
    }

    default By getInvoiceCheckBox() {
        return By.cssSelector("input[name='isInvoiceChecked']");   
    }

    /**
     * @deprecated Use {@link getSubscription_HTMLObject()} instead. getSubscription_HTMLObject and getFranchiseName() have different 'descriptions' in the UI but
     * are the same <Select> object in front-end.
     * **/

    @Deprecated
    default By getFranchiseNameField() {
        return null;   
    }

}
