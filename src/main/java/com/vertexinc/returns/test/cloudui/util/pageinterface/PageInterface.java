package com.vertexinc.returns.test.cloudui.util.pageinterface;

import com.vertexinc.returns.test.cloudui.util.DriverHandler;
import com.vertexinc.returns.test.cloudui.util.DriverHandlerInterface;
import com.vertexinc.returns.test.cloudui.util.Environment;
import org.openqa.selenium.WebDriver;

public interface PageInterface {
    DriverHandler getDriverHandler();

    default void navigatgeTo(Environment environment) {
        getDriverHandler().navigateTo(environment.getURL());
    }

}
