package io.github.nezonium.util;

public class Page implements PageInterface {

    private  DriverHandler driverHandler;

    public Page() {
        this.driverHandler = new DriverHandler();
    }
    public Page(DriverHandler driverHandler){
        this.driverHandler=driverHandler;
    }

    public Page(DriverHandler driverHandler) {
        this.driverHandler = driverHandler;
    }

    @Override
    public DriverHandler getDriverHandler() {
        return this.driverHandler;
    }

}
