/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch06.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Inherited;
import java.lang.annotation.Documented;

/**
 *
 * @author Administrator
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
public @interface Logout {
    String message() default "";
}
