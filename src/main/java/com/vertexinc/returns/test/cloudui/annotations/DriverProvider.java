package com.vertexinc.returns.test.cloudui.annotations;

import com.vertexinc.returns.test.cloudui.util.Browsers;
import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.extension.*;

import java.util.Arrays;
import java.util.Objects;

import static com.vertexinc.returns.test.cloudui.util.Browsers.FIREFOX;
import static com.vertexinc.returns.test.cloudui.util.Browsers.INTERNET_EXPLORER;

public class DriverProvider implements ParameterResolver {

    @RegisterExtension
    SeleniumJupiter seleniumJupiter = new SeleniumJupiter();

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
        return this.seleniumJupiter.supportsParameter(parameterContext, extensionContext);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
        System.out.println(Arrays.toString(extensionContext.getTestClass().get().getAnnotations()));
        Browsers browser = null ;
        switch (Objects.requireNonNull(browser)) {
            case FIREFOX:
                seleniumJupiter.getConfig().setManager(FIREFOX.getWebDriverManagerSupplier().get());
                break;
            case INTERNET_EXPLORER:
                seleniumJupiter.getConfig().setManager(INTERNET_EXPLORER.getWebDriverManagerSupplier().get());
                break;
            default:
                throw new Error("No Driver Specified in @UseDriver or DriverProvider.ResolveParameter() cannot handle ParameterizedTest or Cannot convert Browser to WebDriver - try explicit conversion");
        }
        return this.seleniumJupiter.resolveParameter(parameterContext, extensionContext);
    }

}
