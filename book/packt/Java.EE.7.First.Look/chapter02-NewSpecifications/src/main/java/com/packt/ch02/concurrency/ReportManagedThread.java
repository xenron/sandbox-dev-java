/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch02.concurrency;

/**
 *
 * @author Ndjobo Armel Fabrice
 */
public class ReportManagedThread implements Runnable{

    @Override
    public void run() {
        System.out.println("Thread was executed successfully");
    }
    
}
