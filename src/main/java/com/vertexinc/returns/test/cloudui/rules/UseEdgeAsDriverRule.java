package com.vertexinc.returns.test.cloudui.rules;

import com.vertexinc.returns.test.cloudui.util.Browsers;
import com.vertexinc.returns.test.cloudui.util.DriverHandler;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class UseEdgeAsDriverRule implements DriverRule {

    public final DriverHandler driverHandler;

    public UseEdgeAsDriverRule() {
        this.driverHandler = new DriverHandler(getBrowser());
    }

    @Override
    public Statement apply(Statement statement, Description description) {

        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                DriverHandler driverHandler = new DriverHandler(Browsers.EDGE);
                statement.evaluate();
            }
        };
    }

    @Override
    public Browsers getBrowser() {
        return Browsers.EDGE;
    }

    @Override
    public DriverHandler getDriverHandler() {
        return this.driverHandler;
    }
}
