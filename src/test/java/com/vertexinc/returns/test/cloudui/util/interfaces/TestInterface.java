package com.vertexinc.returns.test.cloudui.util.interfaces;

import com.vertexinc.returns.test.cloudui.util.resources.Environment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

//public interface TestInterface<someEnvironment extends Environment, someBrowser extends WebDriver>{}
public interface TestInterface<someEnvironment extends Environment> extends PageInterface {

    someEnvironment getEnvironment();

    default void browserWait(int milliseconds) {
        synchronized (this) {
            try {
                wait(milliseconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


}
