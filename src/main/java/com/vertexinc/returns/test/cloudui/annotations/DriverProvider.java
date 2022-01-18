package com.vertexinc.returns.test.cloudui.annotations;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.support.AnnotationConsumer;

import java.util.Objects;

import static com.vertexinc.returns.test.cloudui.util.Browsers.*;

public class DriverProvider implements ParameterResolver, AnnotationConsumer<EnumSource> {

    private EnumSource enumSource;

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
                .ifPresent(annotatedElement ->
                {
                    switch (Objects.requireNonNull(annotatedElement.getAnnotation(UseDriver.class).browser())) {
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
        return this.selJup.resolveParameter(parameterContext, extensionContext);
    }

    @Override
    public void accept(EnumSource enumSource) {
        this.enumSource = enumSource;
    }

}//End DriverProvider class
