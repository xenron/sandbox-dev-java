/*
 * Written by Osama Oransa
 * This project is written for the book
 * Java Enterprise Edition 7 Performance Tuning (EN6428).
 */
package osa.ora.outofmemory;

/**
 *
 * @author Osama Oransa
 */
public class BigArrays {

    /**
     * test main method
     *
     * @param args
     */
    public static void main(String args[]) {
        new BigArrays().createArrays();
    }

    /**
     * Method that create big arrays
     */

    public void createArrays() {
        int arraySize = 10;
        while (true) {
            MyInt[] bigArray = new MyInt[arraySize];
            bigArray = null;
            System.out.println("Size =" + arraySize);
            arraySize *= 10;
        }
    }

    /**
     * internal class that wraps the int primitive, similar to Integer class.
     */
    class MyInt {

        int i;
    }

}
