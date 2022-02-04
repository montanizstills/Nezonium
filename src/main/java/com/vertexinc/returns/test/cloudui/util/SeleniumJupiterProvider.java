package com.vertexinc.returns.test.cloudui.util;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.platform.commons.function.Try;
import org.junit.platform.commons.support.HierarchyTraversalMode;
import org.junit.platform.commons.support.ReflectionSupport;
import org.junit.platform.commons.util.Preconditions;


public class SeleniumJupiterProvider {
    @RegisterExtension
    SeleniumJupiter selJup = new SeleniumJupiter();

    public SeleniumJupiter getSeleniumJupiterInstance(ExtensionContext context) {

        Preconditions.notNull(context, "Test context is not available, cannot invoke method: \"getSeleniumJupiterInstance\"\n");
        if (context.getTestClass().isPresent()) {
            ReflectionSupport
                    //find fields where field instanceOf SeleniumJupiter.class
                    .findFields(context.getTestClass().get(), field -> field.getType() == SeleniumJupiter.class, HierarchyTraversalMode.TOP_DOWN)
                    .stream()
                    .findFirst()
                    //try to assign the fields value to selJup or throw Error
                    .ifPresent(field -> Try
                            .call(() -> selJup = (SeleniumJupiter) field.get(null))
                            .orElse(() -> {
                                throw new Error("Cannot convert field!");
                            })
                    );
        }
        return this.selJup;
    }


}//End SeleniumJupiterProvider class
