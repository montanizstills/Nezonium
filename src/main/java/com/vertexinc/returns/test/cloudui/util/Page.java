package com.vertexinc.returns.test.cloudui.util;

public class Page implements PageInterface {

    private final DriverHandler driverHandler;

    public Page(final DriverHandler driverHandler) {
        this.driverHandler = driverHandler;
    }

    @Override
    public DriverHandler getDriverHandler() {
        return this.driverHandler;
    }

}
