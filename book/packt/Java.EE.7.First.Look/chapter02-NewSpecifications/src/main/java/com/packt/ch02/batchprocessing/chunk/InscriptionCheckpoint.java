/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch02.batchprocessing.chunk;

import java.io.Serializable;

/**
 *
 * @author Ndjobo Armel Fabrice
 */
public class InscriptionCheckpoint implements Serializable {
    private int lineNumber;
    
    public void incrementLineNumber(){
        lineNumber++;
    }

    public int getLineNumber() {
        return lineNumber;
    }        
}
