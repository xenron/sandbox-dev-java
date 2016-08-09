/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch02.batchprocessing.batchlet;

import com.packt.ch02.batchprocessing.chunk.Student;
import java.util.ArrayList;
import java.util.List;
import javax.batch.api.AbstractBatchlet;
import javax.batch.runtime.context.JobContext;
import javax.inject.Inject;

/**
 *
 * @author Ndjobo Armel Fabrice
 */
public class StudentInformation extends AbstractBatchlet{
    private List<Student> listOfStudents;
    @Inject
    private JobContext jContext;
    
    public StudentInformation(){
        listOfStudents = new ArrayList<Student>();
        listOfStudents.add(new Student("89614", "JOSS SWISS", "LEVEL1", 24,"jswiss@javaee7fl.com"));
        listOfStudents.add(new Student("71614", "EDARD MELO", "LEVEL1", 30,"emelo@javaee7fl.com"));
        listOfStudents.add(new Student("71694", "EDGARD TIM", "LEVEL2", 21,"etim@javaee7fl.com"));
        listOfStudents.add(new Student("12616", "MICHAEL SELL", "LEVEL3", 30,"msell@javaee7fl.com"));
    }
    
    @Override
    public String process() throws Exception {
       String message = jContext.getProperties().getProperty("MESSAGE");
       for(Student student : listOfStudents){
           System.out.println(message+" - TO - "+student.getAddress());
       }
       return "COMPLETED";
    }
    
}
