package com.vertexinc.returns.test.cloudui;

import com.vertexinc.returns.test.cloudui.util.DriverHandler;
import com.vertexinc.returns.test.cloudui.util.Environment;
import com.vertexinc.returns.test.cloudui.util.pageinterface.TestInterface;
import org.openqa.selenium.WebDriver;

public class TestImpl
        implements TestInterface {

    private Environment environment;
    private WebDriver browser;
    private DriverHandler driverHandler;


    @Override
    public Environment getEnvironment() {
        return this.environment;
    }

    @Override
    public DriverHandler getDriverHandler() {
        return this.driverHandler;
    }

}
