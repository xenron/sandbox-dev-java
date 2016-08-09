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
public class StackOverflow {

    /**
     * test main method
     *
     * @param args
     */
    public static void main(String args[]) {
        new StackOverflow().callIt(10, 10);
    }

    /**
     * Method to call itself to overflow the stack
     *
     * @param x
     * @param y
     */
    public void callIt(int x, int y) {
        callIt(x, y);
    }
}
