/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch08.validator;

import com.packt.ch08.annotation.Case;
import com.packt.ch08.annotation.CaseType;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author Administrator
 */
public class CaseValidator implements ConstraintValidator<Case, String>{

    private CaseType type;
    
    public void initialize(Case annotation) {
        type = annotation.type();
    }

    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value == null)
            return true;        
        
        if (type == CaseType.UPPER) {
            return value.equals(value.toUpperCase());
        } else {
            return value.equals(value.toLowerCase());
        }
    }
    
}
