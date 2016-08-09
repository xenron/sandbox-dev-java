/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch02.batchprocessing.chunk;

import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.batch.annotation.BatchContext;
import javax.batch.api.chunk.AbstractItemWriter;
import javax.batch.runtime.context.JobContext;
import javax.inject.Inject;

/**
 *
 * @author Ndjobo Armel Fabrice
 */
public class StudentNotifier extends AbstractItemWriter {
 
    @Inject            
    private JobContext jcontext;
    
    @Override
    public void open(Serializable checkpoint) throws Exception {
        //...
    }    
       
    
    @Override
    public void writeItems(List<Object> list) throws Exception {
        System.out.println("WriteItems size : "+list.size());
       for(Object obj : list){
           
        if((obj instanceof Student) && ((Student)obj).isApproved()){ 
            Student student = (Student) obj;
             System.out.print("Dear "+student.getName()+", we inform you that your application has been accepted.\n" +
                     "Additional Information:\n" +
                     "  - Registration fee : "+jcontext.getProperties().get("FEES")+" \n" +
                     "  - Your identifier : "+student.getId());
        } else {
            System.out.print("Dear "+((Student)obj).getName()+", we inform you that your application has not been selected");
        }
        
       }
    }
    
    @Override
    public void close() throws Exception {
        //...
    } 
    
    public Serializable checkpointInfo() throws Exception {
        return new InscriptionCheckpoint();
    }
}
