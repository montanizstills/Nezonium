package com.vertexinc.returns.test.cloudui.util.pageinterface;

import com.vertexinc.returns.test.cloudui.util.DriverHandler;
import com.vertexinc.returns.test.cloudui.util.DriverHandlerInterface;
import com.vertexinc.returns.test.cloudui.util.Environment;
import org.openqa.selenium.WebDriver;

public interface TestInterface{

    Environment getEnvironment();

    DriverHandler getDriverHandler();

//    void test();

//    default void test(){
//    setEnvironment(environment);
//    setBrowser(browser);
//    test(environment,browser)
//    }
}

