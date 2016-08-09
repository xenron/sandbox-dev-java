/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch02.batchprocessing.chunk;

import java.util.Calendar;
import java.util.Date;
import javax.batch.annotation.BatchContext;
import javax.batch.api.chunk.ItemProcessor;
import javax.batch.runtime.context.JobContext;
import javax.inject.Inject;

/**
 *
 * @author Ndjobo Armel Fabrice
 */
public class InscriptionProcessor implements ItemProcessor{
    @Inject            
    JobContext jcontext;
    
    @Override
    public Object processItem(Object o) throws Exception {
        if(!(o instanceof Student) || (o == null))
            return null;
        
        Student student = (Student) o;
        int maxLevelAge = Integer.valueOf(jcontext.getProperties().getProperty(student.getLevel()));         
         if(student.getAge() > maxLevelAge)
             student.setApproved(false);
         else
             student.setApproved(true);
         
         System.out.println("student : "+student.getName()+" computed");
         return student;
    }
    
}
