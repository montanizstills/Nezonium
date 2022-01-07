package com.vertexinc.returns.test.cloudui.rules;

import com.vertexinc.returns.test.cloudui.util.Browsers;
import com.vertexinc.returns.test.cloudui.util.DriverHandler;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;


public interface DriverRule extends BeforeAllCallback {
    Browsers getBrowser();

    DriverHandler getDriverHandler();
}
///////////////DELETE THIS CLASS/////////////
