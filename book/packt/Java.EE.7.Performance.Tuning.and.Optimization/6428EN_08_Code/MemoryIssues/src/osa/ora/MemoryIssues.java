/*
 * Written by Osama Oransa
 * This project is written for the book
 * Java Enterprise Edition 7 Performance Tuning (EN6428).
 */
package osa.ora;

import osa.ora.outofmemory.BigArrays;
import osa.ora.outofmemory.ManyObjects;
import osa.ora.outofmemory.StackOverflow;
import osa.ora.outofmemory.TooManyThreads;

/**
 *
 * @author Osama Oransa
 */
public class MemoryIssues {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (args != null && args.length > 0) {
            switch (args[0]) {
                case "0":
                    new ManyObjects().addObject();
                    break;
                case "1":
                    new BigArrays().createArrays();
                    break;
                case "2":
                    new StackOverflow().callIt(10, 10);
                    break;
                case "3":
                    new TooManyThreads().createThreads();
                    break;
            }
        } else {
            System.out.println("No type specified");
        }
    }

}
