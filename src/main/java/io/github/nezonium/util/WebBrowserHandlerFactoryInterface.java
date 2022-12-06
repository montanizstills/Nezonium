package io.github.nezonium.util;

import com.github.git_leon.leonium.browsertools.factories.BrowserHandlerFactoryInterface;
import io.github.bonigarcia.wdm.WebDriverManager;

public interface WebBrowserHandlerFactoryInterface extends BrowserHandlerFactoryInterface {
    WebDriverManager getWebDriverManager();
}
