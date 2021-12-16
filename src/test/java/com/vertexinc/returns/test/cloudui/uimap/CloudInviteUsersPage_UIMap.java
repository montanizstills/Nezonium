package com.vertexinc.returns.test.cloudui.uimap;

import com.vertexinc.returns.test.cloudui.util.PageInterface;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public interface CloudInviteUsersPage_UIMap extends PageInterface {

    default By getInviteUsersButton() {
        return By.cssSelector("a[href='#/inviteNew']");
    }


//    Select role_HTMLSelectObject = new Select(getDriverHandler().getElement(By.cssSelector("select[name='Role']")));
    default Select getRole_HTMLSelectObject() {
        return new Select(getDriverHandler().getElement(By.cssSelector("select[name='Role']")));
    }

    default By getEmailField() {
        return By.id("Email");
    }


    //Customer Admin
    default Select getAccountType_HTMLObject() {
        return  new Select(getDriverHandler().getElement(By.cssSelector("select[name='']")));
    }

    default Select getVarCPAFranchiseName_HTMLObject() {
        return new Select(getDriverHandler().getElement(By.cssSelector("select[name='']")));//todo
    }

    default By getOraclePartyNumberField() {
        return By.cssSelector("input[name='OraclePartyNumber']");
    }

    default By getClientName_Object() {
        return null; //todo
    }

    default Select getCountry_HTMLObject() {
        return new Select(getDriverHandler().getElement(By.cssSelector("select[name='']"))); //todo
    }

    default By getStreetAddressField() {
        return null;//todo
    }

    default By getStreetAddress2Field() {
        return null;//todo
    }

    default By getCityField() {
        return null;//todo
    }

    default Select getState_HTMLObject() {
        return new Select(getDriverHandler().getElement(By.cssSelector("select[name='']"))); //todo
    }

    default By getZipPostalCodeField() {
        return null; //todo
    }

    default Select getSubscription_HTMLObject() {

        return new Select(getDriverHandler().getElement(By.cssSelector("select[name='']"))); //todo
    }

    default By getReservedPod_CheckBox() {
        return null; //todo
    }

    default By getInvoiceCheckBox() {
        return null; //todo
    }

    /**
     * @deprecated Use {@link getSubscription_HTMLObject()} instead. getSubscription_HTMLObject and getFranchiseName() have different 'descriptions' in the UI but
     * are the same <Select> object in front-end.
     * **/

    @Deprecated
    default By getFranchiseNameField() {
        return null; //todo
    }

}
