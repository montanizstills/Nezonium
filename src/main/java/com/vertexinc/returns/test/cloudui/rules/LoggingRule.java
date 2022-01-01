package com.vertexinc.returns.test.cloudui.rules;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import java.util.logging.Logger;


public class LoggingRule implements TestRule {
    private Logger logger;

    @Override
    public Statement apply(Statement statement, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                logger = Logger.getLogger(description.getTestClass().getName()+"."+description.getDisplayName());
                statement.evaluate();
            }
        };
    }
}
