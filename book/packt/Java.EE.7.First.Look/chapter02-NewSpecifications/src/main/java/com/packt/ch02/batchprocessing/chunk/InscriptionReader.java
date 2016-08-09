/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch02.batchprocessing.chunk;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.batch.api.chunk.AbstractItemReader;

/**
 *
 * @author Ndjobo Armel Fabrice
 */
public class InscriptionReader extends AbstractItemReader {

    private List<Student> listOfStudents;
    private InscriptionCheckpoint InsCheckpoint;
    
    public InscriptionReader(){
        listOfStudents = new ArrayList<Student>();
        listOfStudents.add(new Student("89614", "JOSS SWISS", "LEVEL1", 24,"jswiss@javaee7fl.com"));
        listOfStudents.add(new Student("71614", "EDARD MELO", "LEVEL1", 30,"emelo@javaee7fl.com"));
        listOfStudents.add(new Student("71694", "EDGARD TIM", "LEVEL2", 21,"etim@javaee7fl.com"));
        listOfStudents.add(new Student("12616", "MICHAEL SELL", "LEVEL3", 30,"msell@javaee7fl.com"));        
    }
    
    @Override
    public void open(Serializable checkpoint) throws Exception {        
        if(checkpoint == null)
            InsCheckpoint = new InscriptionCheckpoint();
        else 
            InsCheckpoint = (InscriptionCheckpoint) checkpoint;                        
        
        System.out.println("Reader was open");
    }

    @Override
    public Object readItem() throws Exception {     
        int index = InsCheckpoint.getLineNumber();
        InsCheckpoint.incrementLineNumber();
        
        if(index < listOfStudents.size()){            
            return listOfStudents.get(index);
        } else {
            return null;
        }
    }

    public void close() throws Exception {
        listOfStudents = null;
        System.out.println("Reader was closed");
    }    
}
