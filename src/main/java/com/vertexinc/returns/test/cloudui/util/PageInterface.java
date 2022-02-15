package com.vertexinc.returns.test.cloudui.util;

public interface PageInterface {
    /**
     * This method is used to expose the DriverHandler to implementing subclasses
     **/
    DriverHandler getDriverHandler();

    /**
     * This following helper methods:
     **/

    default String getCurrentURL() {
        return getDriverHandler().getCurrentUrl();
    }

    default void clickBackButton(){
        getDriverHandler().clickBackButton();
    }

    default void clickForwardButton(){
        getDriverHandler().clickForwardButton();
    }

    default void clickRefreshButton(){
        getDriverHandler().clickRefreshButton();
    }

    default void navigateTo(String url) {
        getDriverHandler().navigateTo(url);
    }

}
