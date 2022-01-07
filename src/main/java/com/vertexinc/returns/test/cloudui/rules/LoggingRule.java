package com.vertexinc.returns.test.cloudui.rules;

import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.util.logging.Logger;


public class LoggingRule implements BeforeTestExecutionCallback {
    private Logger logger;

    @Override
    public void beforeTestExecution(ExtensionContext extensionContext) throws Exception {

    }
}
