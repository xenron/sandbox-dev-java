/*
 * Written by Osama Oransa
 * This project is written for the book
 * Java Enterprise Edition 7 Performance Tuning (EN6428).
 */
package osa.ora.outofmemory;

import java.util.ArrayList;

/**
 *
 * @author Osama Oransa
 */
public class ManyObjects {

    /**
     * test main method
     *
     * @param args
     */
    public static void main(String args[]) {
        new ManyObjects().addObject();
    }

    /**
     * Method that keep add objects
     */
    public void addObject() {
        ArrayList list = new ArrayList();
        while (true) {
            list.add(new String("Osama Oransa"));
            //un-commit this line to get slow results
            //to visualize the memory profiling using JVisualVM or other tools
            //try {
            //    Thread.sleep(0, 5);
            //} catch (InterruptedException ex) {
            //}
        }
    }

}
