/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch02.concurrency;

import java.util.concurrent.Callable;

/**
 *
 * @author Ndjobo Armel Fabrice
 */
public class ReportGeneratorTask implements Callable<String>{

    @Override
    public String call() throws Exception {
        //generate report
        return "The report was generated successfully";
    }   
}
