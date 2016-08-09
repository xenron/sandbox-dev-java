/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch08.validation;

import com.packt.ch08.entities.Student;
import java.util.Set;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

/**
 *
 * @author Administrator
 */
@Singleton
@Startup
public class InjectValidators {
    
    private Logger logger = Logger.getLogger(InjectValidators.class.getName());

    @Inject
    private Validator validator;

    @PostConstruct
    public void init() {
        Student student = new Student();
        Set<ConstraintViolation<Student>> violations = validator.validate(student);
        logger.info("InjectValidators-Number of violations : " + violations.size());
        for (ConstraintViolation<Student> cons : violations) {
            logger.info("Calss :" + cons.getRootBeanClass() + ", Instance : " + cons.getLeafBean() + ", "
                    + " attribute : " + cons.getPropertyPath() + ", message :" + cons.getMessage());
        }
    }
}
