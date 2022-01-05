package com.vertexinc.returns.test.cloudui.util;

public interface PageInterface {
    /**
     * This method is used to expose the driverHandler to implementing subclasses
     **/
    DriverHandler getDriverHandler();

    /**
     * This following - method architecture hides unneeded knowledge concerning the inner-workings of the DriverHandler from the user.
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
