package com.vertexinc.returns.test.cloudui.util.concretepage;

import com.vertexinc.returns.test.cloudui.util.DriverHandler;
import com.vertexinc.returns.test.cloudui.util.pageinterface.CloudInviteUsersPageInterface;

public class CloudInviteUsersPage implements CloudInviteUsersPageInterface {
    private DriverHandler driverHandler;

    public CloudInviteUsersPage(DriverHandler driverHandler) {

    }

    @Override
    public DriverHandler getDriverHandler() {
        return this.driverHandler;
    }

    public void clickInviteUsersButton() {
        getDriverHandler().click(getInviteUsersButton());
    }
}
