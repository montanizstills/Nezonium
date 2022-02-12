package com.vertexinc.returns.test.cloudui.util.annotationutils;

import com.vertexinc.returns.test.cloudui.annotations.ScreenShotOnFail;
import com.vertexinc.returns.test.cloudui.util.SeleniumJupiterProvider;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ScreenShotRuleProperties implements TestWatcher {

    public void takeScreenshot(ExtensionContext context){
        //fullscreen - default assumes OS is not mobile.
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(SeleniumJupiterProvider.getInstance().getConfig().getManager().getWebDriver());
        context.getTestMethod().ifPresent(testMethod->{
            File imgFile = new File(testMethod.getName()+".png");
            try {
                ImageIO.write(screenshot.getImage(),"png",imgFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        System.out.println("Test failed! Starting 'Failed-Test' data collection protocol as per `@ScreenShotOnFail` method annotation.");
        //Log.log(cause.getMessage())
        takeScreenshot(context);
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        System.out.println("Test ran successfully!");
    }
}//End ScreenShotRuleProperties class

