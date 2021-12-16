package com.vertexinc.returns.test.cloudui.concretepage;

import com.vertexinc.returns.test.cloudui.util.DriverHandler;
import com.vertexinc.returns.test.cloudui.util.Page;
import com.vertexinc.returns.test.cloudui.uimap.CloudInviteUsersPage_UIMap;

public class CloudInviteUsersPage extends Page implements CloudInviteUsersPage_UIMap {

    public CloudInviteUsersPage(DriverHandler driverHandler) {
        super(driverHandler);
    }

    @Override
    public DriverHandler getDriverHandler() {
        return super.getDriverHandler();
    }

    public void clickInviteUsersButton() {
        getDriverHandler().click(getInviteUsersButton());
    }

    public void enterOraclePartyNumber(String oraclePartyNumber) {
        getDriverHandler().sendKeys(getOraclePartyNumberField(),oraclePartyNumber);
    }

    public String getOraclePartyNumber() {
        return getDriverHandler().getText(getOraclePartyNumberField());
    }
}
