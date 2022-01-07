package com.vertexinc.returns.test.cloudui.rules;

import com.vertexinc.returns.test.cloudui.util.Browsers;
import com.vertexinc.returns.test.cloudui.util.DriverHandler;
import org.junit.jupiter.api.extension.ExtensionContext;

public class UseEdgeAsDriverRule implements DriverRule {

    public final DriverHandler driverHandler;

    public UseEdgeAsDriverRule() {
        this.driverHandler = new DriverHandler(getBrowser());
    }

    @Override
    public Browsers getBrowser() {
        return Browsers.EDGE;
    }

    @Override
    public DriverHandler getDriverHandler() {
        return this.driverHandler;
    }


    @Override
    public void beforeAll(ExtensionContext extensionContext) throws Exception {

    }
}
