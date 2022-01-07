package com.vertexinc.returns.test.cloudui.rules;

import com.vertexinc.returns.test.cloudui.util.Browsers;
import com.vertexinc.returns.test.cloudui.util.DriverHandler;
import org.junit.jupiter.api.extension.ExtensionContext;

public final class UseChromeAsDriverRule implements DriverRule {

    private final DriverHandler driverHandler;

    public UseChromeAsDriverRule() {
        this.driverHandler = new DriverHandler(getBrowser());
    }


    @Override
    public Browsers getBrowser() {
        return Browsers.CHROME;
    }

    @Override
    public DriverHandler getDriverHandler() {
        return this.driverHandler;
    }

    @Override
    public void beforeEach(ExtensionContext extensionContext) throws Exception {

    }
}
