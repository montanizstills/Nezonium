package io.github.nezonium.annotations;

import io.github.nezonium.util.annotationutils.ScreenShotRulePropertiesProvider;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(ScreenShotRulePropertiesProvider.class)
@Deprecated
public @interface ScreenShotOnFail {
    String CHROME_DIR_DEFAULT = "src/main/java/resources/chrome";
    String EDGE_DIR_DEFAULT = "/src/main/java/resources/edge";
    String FIREFOX_DIR_DEFAULT = "/src/main/java/resources/firefox";
    String INTERNET_EXPLORER_DIR_DEFAULT = "/src/main/java/resources/internet_explorer";
    String OPERA_DIR_DEFAULT = "/src/main/java/resources/opera";
    String SAFARI_DIR_DEFAULT = "/src/main/java/resources/safari";

}
