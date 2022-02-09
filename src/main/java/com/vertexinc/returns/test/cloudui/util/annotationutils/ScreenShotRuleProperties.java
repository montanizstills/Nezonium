package com.vertexinc.returns.test.cloudui.util.annotationutils;

import com.vertexinc.returns.test.cloudui.annotations.ScreenShotOnFail;
import com.vertexinc.returns.test.cloudui.util.SeleniumJupiterProvider;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

public class ScreenShotRuleProperties implements TestWatcher {

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        System.out.println("Test failed! Starting 'Failed-Test' data collection protocol as per `@ScreenShotOnFail` method annotation.");
        //Log.log(cause.getMessage())
        context.getElement().ifPresent(annotatedElement -> {
            System.out.println("Test context exists. Continuing data collection protocol.");
            SeleniumJupiterProvider.getInstance().getConfig().setOutputFolder(FileUtils.getUserDirectory() + "/" + annotatedElement.getAnnotation(ScreenShotOnFail.class).screenshotOutputDir());
            System.out.println(SeleniumJupiterProvider.getInstance().getConfig().getOutputFolder());
            SeleniumJupiterProvider.getInstance().getConfig().takeScreenshotAsPng();
        });
    }

}//End ScreenShotRuleProperties class

