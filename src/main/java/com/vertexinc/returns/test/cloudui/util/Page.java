package com.vertexinc.returns.test.cloudui.util;

import com.vertexinc.returns.test.cloudui.util.pageinterface.PageInterface;

public class Page implements PageInterface {

    private final DriverHandler driverHandler;

    public Page(DriverHandler driverHandler) {
        this.driverHandler = driverHandler;

    }

    @Override
    public DriverHandler getDriverHandler() {
        return this.driverHandler;
    }

}
