package com.vertexinc.returns.test.cloudui.util.concretepage;

import com.vertexinc.returns.test.cloudui.util.DriverHandler;
import com.vertexinc.returns.test.cloudui.util.Page;
import com.vertexinc.returns.test.cloudui.util.pageinterface.CloudHomePageInterface;
import org.openqa.selenium.interactions.Actions;

public class CloudHomePage extends Page implements CloudHomePageInterface {


    public CloudHomePage(DriverHandler driverHandler) {
        super(driverHandler);

    }

    @Override
    public DriverHandler getDriverHandler() {
        return super.getDriverHandler();
    }

    public void clickInviteUsers() {
        getDriverHandler().click(getInviteUsersButton());
    }

    public void clickRatesJurisdictionButton() {
        getDriverHandler().click(getRatesJurisdictionButton());
    }

    public void clickECWLogsButton() {
        Actions actions = new Actions(getDriverHandler().getDriver());
        actions.moveToElement(getDriverHandler().getDriver().findElement(getLogsButton())).perform();
        getDriverHandler().click(getLogsECWLogsButton());
    }
}
