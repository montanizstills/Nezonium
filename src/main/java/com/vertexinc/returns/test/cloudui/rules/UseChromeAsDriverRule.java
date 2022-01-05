package com.vertexinc.returns.test.cloudui.rules;

import com.vertexinc.returns.test.cloudui.util.Browsers;
import com.vertexinc.returns.test.cloudui.util.DriverHandler;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public final class UseChromeAsDriverRule implements DriverRule {

    private final DriverHandler driverHandler;

    public UseChromeAsDriverRule() {
        this.driverHandler = new DriverHandler(getBrowser());
    }

    @Override
    public Statement apply(Statement statement, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                statement.evaluate();
            }
        };
    }

    @Override
    public Browsers getBrowser() {
        return Browsers.CHROME;
    }

    @Override
    public DriverHandler getDriverHandler() {
        return this.driverHandler;
    }
}
