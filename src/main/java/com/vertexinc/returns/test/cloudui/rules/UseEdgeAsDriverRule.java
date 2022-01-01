package com.vertexinc.returns.test.cloudui.rules;

import com.vertexinc.returns.test.cloudui.util.Browsers;
import com.vertexinc.returns.test.cloudui.util.DriverHandler;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class UseEdgeAsDriverRule implements TestRule {

//    public final DriverHandler driverHandler = new DriverHandler(Browsers.EDGE);

    public UseEdgeAsDriverRule(){}

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
}
