package io.github.nezonium.annotations;

import com.github.git_leon.leonium.browsertools.factories.BrowserHandlerFactory;
import io.github.nezonium.util.annotationutils.WebBrowserArgumentsProvider;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
//@Documented - denotes API documentation will be cascaded
//@Inherited - denotes if subclasses will inherit super's annotations.
@ParameterizedTest(name = "Executing with {argumentsWithNames} - {displayName}")
@ArgumentsSource(WebBrowserArgumentsProvider.class)
public @interface UseDriver {
    BrowserHandlerFactory[] browser();
}
