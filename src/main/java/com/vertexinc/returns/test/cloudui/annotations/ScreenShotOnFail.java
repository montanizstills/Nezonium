package com.vertexinc.returns.test.cloudui.annotations;

import com.vertexinc.returns.test.cloudui.util.annotationutils.ScreenShotRuleProperties;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@ExtendWith({ScreenShotRuleProperties.class})
public @interface ScreenShotOnFail {
    String screenshotOutputDir() default ScreenShotOnFail.NO_DEFAULT_DIR_SPECIFIED;
    String CHROME_DIR_DEFAULT = "src/main/java/resources/chrome";
    String EDGE_DIR_DEFAULT = "src/main/java/resources/edge";
    String FIREFOX_DIR_DEFAULT = "src/main/java/resources/firefox";
    String INTERNET_EXPLORER_DIR_DEFAULT = "src/main/java/resources/internet_explorer";
    String OPERA_DIR_DEFAULT = "src/main/java/resources/opera";
    String SAFARI_DIR_DEFAULT = "src/main/java/resources/safari";
    String NO_DEFAULT_DIR_SPECIFIED = "src/main/java/resources/default_screenshot_output_dir";
}
