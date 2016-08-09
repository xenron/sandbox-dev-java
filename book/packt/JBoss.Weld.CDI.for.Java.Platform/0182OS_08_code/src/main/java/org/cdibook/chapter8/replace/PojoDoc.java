package org.cdibook.chapter8.replace;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface PojoDoc {
    String value();
    ScopeEnum scope() default ScopeEnum.REQUEST;
}
