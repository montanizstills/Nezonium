package com.vertexinc.returns.test.cloudui.annotations;

import com.vertexinc.returns.test.cloudui.util.SeleniumJupiterProvider;
import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolver;

import java.util.Objects;

import static com.vertexinc.returns.test.cloudui.util.Browsers.*;

public class DriverProvider implements ParameterResolver {

    SeleniumJupiterProvider seleniumJupiterProvider = new SeleniumJupiterProvider();

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
        return this.seleniumJupiterProvider.getSeleniumJupiterInstance(extensionContext).supportsParameter(parameterContext, extensionContext);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {

        extensionContext.getElement().ifPresent(element ->
        {
            switch (Objects.requireNonNull(element.getAnnotation(UseDriver.class).browser())) {
                case FIREFOX:
                    seleniumJupiterProvider
                            .getSeleniumJupiterInstance(extensionContext)
                            .getConfig()
                            .setManager(FIREFOX.getWebDriverManagerSupplier().get());
                    break;
                case CHROME:
                    seleniumJupiterProvider
                            .getSeleniumJupiterInstance(extensionContext)
                            .getConfig()
                            .setManager(CHROME.getWebDriverManagerSupplier().get());
                    break;
                case OPERA:
                    seleniumJupiterProvider
                            .getSeleniumJupiterInstance(extensionContext)
                            .getConfig()
                            .setManager(OPERA.getWebDriverManagerSupplier().get());
                    break;
                case INTERNET_EXPLORER:
                    seleniumJupiterProvider
                            .getSeleniumJupiterInstance(extensionContext)
                            .getConfig()
                            .setManager(INTERNET_EXPLORER.getWebDriverManagerSupplier().get());
                    break;
                case EDGE:
                    seleniumJupiterProvider
                            .getSeleniumJupiterInstance(extensionContext)
                            .getConfig()
                            .setManager(EDGE.getWebDriverManagerSupplier().get());
                    break;
                case SAFARI:
                    seleniumJupiterProvider
                            .getSeleniumJupiterInstance(extensionContext)
                            .getConfig().
                            setManager(SAFARI.getWebDriverManagerSupplier().get());
                default:
                    throw new Error("No Driver Specified in @UseDriver or DriverProvider.ResolveParameter() cannot handle ParameterizedTest or Cannot convert Browser to WebDriver - try explicit conversion");
            }
        });
//        What about multiple browsers supplied? How to resolve one Browser at a time??
        return seleniumJupiterProvider.getSeleniumJupiterInstance(extensionContext).resolveParameter(parameterContext, extensionContext);
    }


}//End DriverProvider class
