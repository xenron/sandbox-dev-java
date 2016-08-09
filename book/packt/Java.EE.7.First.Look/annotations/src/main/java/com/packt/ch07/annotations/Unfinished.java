/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch07.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/**
 *
 * @author Administrator
 */
@Target({ElementType.METHOD, ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.SOURCE)
public @interface Unfinished {
    String message() default "Nothing has been done";
}
