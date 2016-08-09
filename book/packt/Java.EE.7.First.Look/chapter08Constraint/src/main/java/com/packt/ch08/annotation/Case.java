/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch08.annotation;

import com.packt.ch08.validator.CaseValidator;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 *
 * @author Administrator
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CaseValidator.class)
public @interface Case {
    String message() default "This value must be uppercase";    
    CaseType type() default CaseType.UPPER;
    Class<? extends Payload>[] payload() default {};
    Class<?>[] groups() default {};
}
