package com.vertexinc.returns.test.cloudui.annotations;

import com.vertexinc.returns.test.cloudui.util.Browsers;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.TYPE, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Browser {
    Browsers webdriver();
}
