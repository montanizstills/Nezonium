package com.vertexinc.returns.test.cloudui.util.concretepage;

import com.vertexinc.returns.test.cloudui.util.DriverHandler;
import com.vertexinc.returns.test.cloudui.util.Page;
import com.vertexinc.returns.test.cloudui.util.pageinterface.CloudInviteUsersPageInterface;

public class CloudInviteUsersPage extends Page implements CloudInviteUsersPageInterface {

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
}
