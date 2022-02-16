package io.github.nezonium.util.annotationutils;

import io.github.nezonium.annotations.UseDriver;
import io.github.nezonium.util.WebBrowser;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.*;
import java.util.stream.Stream;

public class WebBrowserArgumentsProvider implements ArgumentsProvider {
    WebBrowser[] browsers;

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        extensionContext
                .getElement()
                .ifPresent(reflectedAnnotationElement ->
                        this.browsers = reflectedAnnotationElement
                                .getAnnotation(UseDriver.class)
                                .browser());
//        return Stream.of(Arguments.of(this.browsers)); why did this not @ParameterizedTest?
        return Arrays.stream(Arrays.stream(browsers).toArray()).map(Arguments::of);
    }

}//End DriverProvider class
