package io.github.nezonium.util;

public class Page implements PageInterface {

    private final DriverHandler driverHandler;

    public Page() {
        this.driverHandler = new DriverHandler();
    }

    @Override
    public DriverHandler getDriverHandler() {
        return this.driverHandler;
    }

}
