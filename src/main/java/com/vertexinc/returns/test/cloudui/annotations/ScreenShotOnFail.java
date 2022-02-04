package com.vertexinc.returns.test.cloudui.annotations;

import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(ScreenShotRuleProperties.class)
public @interface ScreenShotOnFail {
    public String CHROME_DIR_DEFAULT = "src/main/java/resources/chrome";
    public String EDGE_DIR_DEFAULT = "src/main/java/edge";
    public String FIREFOX_DIR_DEFAULT = "src/main/java/edge";
    public String INTERNET_EXPLORER_DIR_DEFAULT = "src/main/java/internet_explorer";
    public String OPERA_DIR_DEFAULT = "src/main/java/opera" ;
    String SAFARI_DIR_DEFAULT = "src/main/java/safari";

//    Instance of SelJup in DataProvider.class - creating another for this
//    meta-annotation may introduce an Inversion of Control (IOC) error.
//    Need only one instance of SelJup, how to abstract?
}
