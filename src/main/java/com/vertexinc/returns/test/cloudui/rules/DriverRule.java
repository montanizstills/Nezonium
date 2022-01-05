package com.vertexinc.returns.test.cloudui.rules;

import com.vertexinc.returns.test.cloudui.util.Browsers;
import com.vertexinc.returns.test.cloudui.util.DriverHandler;
import org.junit.rules.TestRule;

public interface DriverRule extends TestRule {
    Browsers getBrowser();

    DriverHandler getDriverHandler();
}

