package com.vertexinc.returns.test.cloudui.util.pageinterface;

import com.vertexinc.returns.test.cloudui.util.DriverHandler;
import com.vertexinc.returns.test.cloudui.util.Environment;

public interface PageInterface {
    DriverHandler getDriverHandler(); //to expose the driverHandler to implementing subclasses

    default String getCurrentURL() {
        return getDriverHandler().getDriver().getCurrentUrl();
    }
    default void navigateTo(Environment environment) {
        getDriverHandler().navigateTo(environment.getURL());
    }

}
