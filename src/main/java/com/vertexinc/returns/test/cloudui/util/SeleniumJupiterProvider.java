package com.vertexinc.returns.test.cloudui.util;

import io.github.bonigarcia.seljup.SeleniumJupiter;

public class SeleniumJupiterProvider {

    private static SeleniumJupiter selJup = new SeleniumJupiter();

    private SeleniumJupiterProvider() {}//SINGLETON PATTERN

    public static SeleniumJupiter getInstance() {
        return selJup;
    }

//    public SeleniumJupiter getSeleniumJupiterInstance(ExtensionContext context) {
//        Preconditions.notNull(context, "Test context is not available, cannot invoke method: \"getSeleniumJupiterInstance\"\n");
//        if (context.getTestClass().isPresent()) {
//            ReflectionSupport
//                    //find fields where field instanceOf SeleniumJupiter.class
//                    .findFields(context.getTestClass().get(), field -> field.getType().isInstance(this), HierarchyTraversalMode.TOP_DOWN)
//                    .stream()
//                    .findFirst()
//                    //try to assign the fields value to selJup or throw Error
//                    .ifPresent(field -> Try
//                            .call(() -> selJup = ((SeleniumJupiterProvider) field.get(null)))
//                            .orElse(() -> {
//                                throw new Error("Cannot convert field!");
//                            })
//                    );
//        }
//        return this.selJup;
//    }

    }//End SeleniumJupiterProvider class
