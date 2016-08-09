package com.packt.ch08.chapter08manualvalidation;

import com.packt.ch08.entities.Student;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        Student student = new Student();
        student.setEmail("qsdfqsdfqsdfsqdfqsdfqsdf");
        student.setPhone("dfqsdfqsdfqsdfqsdfqsdfqsd");
        
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        
        Set<ConstraintViolation<Student>> violations = validator.validate(student);
        System.out.println("Number of violations : "+violations.size());
        for(ConstraintViolation<Student> cons : violations){
            System.out.println("Calss :"+cons.getRootBeanClass()+", Instance : "+cons.getLeafBean()+", "
                    + " attribute : "+cons.getPropertyPath()+", message :"+cons.getMessage());
        }
    }        
}
