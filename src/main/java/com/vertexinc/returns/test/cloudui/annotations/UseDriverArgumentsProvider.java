package com.vertexinc.returns.test.cloudui.annotations;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.Arrays;
import java.util.stream.Stream;

public class UseDriverArgumentsProvider implements ArgumentsProvider {

    Stream<Arguments> objects = null;

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        extensionContext.getElement().ifPresent(annotatedElement ->
                {
                    setObjects(Stream.of(annotatedElement.getAnnotation(UseDriver.class)).map(Arguments::of));
                }
        );
        return this.objects;
    }

    private void setObjects(Stream<Arguments> argumentsStream) {
        this.objects = argumentsStream;
    }
}
