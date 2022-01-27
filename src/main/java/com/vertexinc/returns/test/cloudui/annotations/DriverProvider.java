package com.vertexinc.returns.test.cloudui.annotations;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.junit.platform.commons.function.Try;
import org.junit.platform.commons.support.HierarchyTraversalMode;
import org.junit.platform.commons.support.ReflectionSupport;
import org.junit.platform.commons.util.Preconditions;

import java.util.Objects;

import static com.vertexinc.returns.test.cloudui.util.Browsers.*;

public class DriverProvider implements ParameterResolver {

    SeleniumJupiter selJup;

    SeleniumJupiter getSeleniumJupiterInstance(ExtensionContext context) {
        Preconditions.notNull(context,"Test context is not available, cannot invoke method: \"getSeleniumJupiterInstance\"\n");
        if (context.getTestClass().isPresent()) {
            ReflectionSupport
                    //find fields where field instanceOf SeleniumJupiter.class
                    .findFields(context.getTestClass().get(), field -> true, HierarchyTraversalMode.TOP_DOWN)
                    .stream()
                    .findFirst()
                    //try to assign the fields value to selJup or throw Error
                    .ifPresent(field -> Try
                                    .call(() -> selJup = (SeleniumJupiter) field.get(null))
                                    .orElse(()->{throw new Error("Cannot convert field!");})
                    );
        }
        return this.selJup;
    }

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
        return this.getSeleniumJupiterInstance(extensionContext).supportsParameter(parameterContext, extensionContext);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
        extensionContext.getElement().ifPresent(element ->
        {
            switch (Objects.requireNonNull(element.getAnnotation(UseDriver.class).browser())) {
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
        });
//        What about multiple browsers supplied? How to resolve one Browser at a time??
        return getSeleniumJupiterInstance(extensionContext).resolveParameter(parameterContext, extensionContext);
    }


}//End DriverProvider class
