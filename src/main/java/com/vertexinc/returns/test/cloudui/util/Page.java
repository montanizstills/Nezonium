package com.vertexinc.returns.test.cloudui.util;

import com.vertexinc.returns.test.cloudui.util.pageinterface.PageInterface;
import org.openqa.selenium.WebDriver;

public class Page implements PageInterface {

    private final DriverHandler driverHandler;

    public Page(WebDriver driver) {
        this.driverHandler = new DriverHandler(driver);

    }

    @Override
    public DriverHandler getDriverHandler() {
        return this.driverHandler;
    }

}
