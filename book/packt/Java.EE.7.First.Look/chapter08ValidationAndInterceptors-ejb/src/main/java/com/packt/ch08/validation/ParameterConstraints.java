/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch08.validation;

import com.packt.ch08.entities.Student;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.executable.ExecutableValidator;

/**
 *
 * @author Administrator
 */
@Singleton
@Startup
public class ParameterConstraints {
    private Logger logger = Logger.getLogger(InjectValidators.class.getName());
    @Inject
    ExecutableValidator validator;
    
    @PostConstruct
    public void init() {                
        try {
            ParameterConstraints pc = new ParameterConstraints();
            Method method = ParameterConstraints.class.getMethod("createStudent", Student.class);
            Object[] params = {null};
            Set<ConstraintViolation<ParameterConstraints>> violations = validator.validateParameters(
                    pc,
                    method,
                    params);
            
            logger.info("ParameterConstraints-Number of violations : " + violations.size());
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(ParameterConstraints.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(ParameterConstraints.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Size(max = 2)
    public String createStudent(@NotNull Student std) {
        return "123456";
    }
}
