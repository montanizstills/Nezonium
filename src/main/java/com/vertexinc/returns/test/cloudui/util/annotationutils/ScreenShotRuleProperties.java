package com.vertexinc.returns.test.cloudui.util.annotationutils;

import com.vertexinc.returns.test.cloudui.util.SeleniumJupiterProvider;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ScreenShotRuleProperties implements TestWatcher {

    public void takeScreenshot(ExtensionContext context) {
        Screenshot screenshot = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(100))  //TODO - fullscreen is default assumes OS is not mobile. What about Screenshots from OS testing?
                .takeScreenshot(SeleniumJupiterProvider
                        .getInstance()
                        .getConfig()
                        .getManager()
                        .getWebDriver());
        File imgFile = new File(context.getDisplayName() + ".png"); //TODO - change default file directory to 'src/main/resources/{runTimeBrowserType}/'
        try {
            ImageIO.write(screenshot.getImage(), "png", imgFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        //Log.log(cause.getMessage())
        takeScreenshot(context);
    }

}//End ScreenShotRuleProperties class

