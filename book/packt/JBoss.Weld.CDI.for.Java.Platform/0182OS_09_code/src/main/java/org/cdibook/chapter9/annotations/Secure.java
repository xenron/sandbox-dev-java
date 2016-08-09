package org.cdibook.chapter9.annotations;

import org.cdibook.chapter9.enums.RoleType;

import javax.enterprise.util.Nonbinding;
import javax.interceptor.InterceptorBinding;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@InterceptorBinding
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Secure {

    @Nonbinding
    RoleType[] rolesAllowed() default {};
}
