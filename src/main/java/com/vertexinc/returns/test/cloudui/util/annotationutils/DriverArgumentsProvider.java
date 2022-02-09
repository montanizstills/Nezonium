package com.vertexinc.returns.test.cloudui.util.annotationutils;

import com.vertexinc.returns.test.cloudui.annotations.UseDriver;
import com.vertexinc.returns.test.cloudui.util.Browsers;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.Arrays;
import java.util.stream.Stream;

public class DriverArgumentsProvider implements ArgumentsProvider {
    Browsers[] browsers;

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        extensionContext
                .getElement()
                .ifPresent(annotatedElement ->
                        this.browsers = annotatedElement
                                .getAnnotation(UseDriver.class)
                                .browser());
//        return Stream.of(Arguments.of(this.browsers)); why did this not @ParameterizedTest?
        return Arrays.stream(this.browsers).map(Arguments::of);
    }

}//End DriverProvider class
