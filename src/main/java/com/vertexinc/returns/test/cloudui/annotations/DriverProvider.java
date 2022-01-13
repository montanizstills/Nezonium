package com.vertexinc.returns.test.cloudui.annotations;

import com.vertexinc.returns.test.cloudui.util.Browsers;
import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.junit.jupiter.api.extension.RegisterExtension;

import java.util.Objects;

import static com.vertexinc.returns.test.cloudui.util.Browsers.*;

public class DriverProvider implements ParameterResolver {

    Browsers browser;

    @RegisterExtension
    SeleniumJupiter selJup = new SeleniumJupiter();

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
        return this.selJup.supportsParameter(parameterContext, extensionContext);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
        extensionContext
                .getElement()
                .ifPresent(annotatedElement -> setBrowser(annotatedElement.getAnnotation(UseDriver.class).browser()));
//        What about multiple browsers supplied? How to resolve one Browser at a time?? Try inheriting @ParameterizedTest
        switch (Objects.requireNonNull(browser)) {
            case FIREFOX:
                selJup.getConfig().setManager(FIREFOX.getWebDriverManagerSupplier().get());
                break;
            case CHROME:
                selJup.getConfig().setManager(CHROME.getWebDriverManagerSupplier().get());
                break;
            case OPERA:
                selJup.getConfig().setManager(OPERA.getWebDriverManagerSupplier().get());
                break;
            case INTERNET_EXPLORER:
                selJup.getConfig().setManager(INTERNET_EXPLORER.getWebDriverManagerSupplier().get());
                break;
            case EDGE:
                selJup.getConfig().setManager(EDGE.getWebDriverManagerSupplier().get());
                break;
            case SAFARI:
                selJup.getConfig().setManager(SAFARI.getWebDriverManagerSupplier().get());
            default:
                throw new Error("No Driver Specified in @UseDriver or DriverProvider.ResolveParameter() cannot handle ParameterizedTest or Cannot convert Browser to WebDriver - try explicit conversion");
        }
        return this.selJup.resolveParameter(parameterContext, extensionContext);
    }

    private void setBrowser(Browsers[] browser) {
        this.browser = browser[0];
    }

}
