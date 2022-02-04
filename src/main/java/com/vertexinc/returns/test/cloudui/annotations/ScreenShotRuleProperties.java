package com.vertexinc.returns.test.cloudui.annotations;

import com.vertexinc.returns.test.cloudui.util.SeleniumJupiterProvider;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Objects;

public class ScreenShotRuleProperties implements TestWatcher {

 SeleniumJupiterProvider seleniumJupiterProvider;

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        //Log.log(cause.getMessage())
        context.getElement().ifPresent(element ->
        {
            switch (Objects.requireNonNull(element.getAnnotation(UseDriver.class).browser())) {
                case FIREFOX:
                    seleniumJupiterProvider.getSeleniumJupiterInstance(context).getConfig().setOutputFolder(ScreenShotOnFail.FIREFOX_DIR_DEFAULT);
                    break;
                case CHROME:
                    seleniumJupiterProvider.getSeleniumJupiterInstance(context).getConfig().setOutputFolder(ScreenShotOnFail.CHROME_DIR_DEFAULT);
                    break;
                case OPERA:
                    seleniumJupiterProvider.getSeleniumJupiterInstance(context).getConfig().setOutputFolder(ScreenShotOnFail.OPERA_DIR_DEFAULT);
                    break;
                case INTERNET_EXPLORER:
                    seleniumJupiterProvider.getSeleniumJupiterInstance(context).getConfig().setOutputFolder(ScreenShotOnFail.INTERNET_EXPLORER_DIR_DEFAULT);
                    break;
                case EDGE:
                    seleniumJupiterProvider.getSeleniumJupiterInstance(context).getConfig().setOutputFolder(ScreenShotOnFail.EDGE_DIR_DEFAULT);
                    break;
                case SAFARI:
                    seleniumJupiterProvider.getSeleniumJupiterInstance(context).getConfig().setOutputFolder(ScreenShotOnFail.SAFARI_DIR_DEFAULT);
                default:
                    throw new Error("Driver type unsupported. Please Support Driver type in DriverProvider.class");
            }
        });
        seleniumJupiterProvider.getSeleniumJupiterInstance(context).getConfig().takeScreenshotAsPng();
    }

}//End ScreenShotRuleProperties class

