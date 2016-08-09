/*
 * Written by Osama Oransa
 * This project is written for the book
 * Java Enterprise Edition 7 Performance Tuning (EN6428)
 */
package osa.ora.beans;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Osama Oransa
 */
public class TransferLock implements Runnable {

    int id;
    AccountWithLock fromAccount;
    AccountWithLock toAccount;
    int amount;

    /**
     * constructor to create Transfer object
     *
     * @param id
     * @param fromAccount
     * @param toAccount
     * @param amonut
     */
    public TransferLock(int id, AccountWithLock fromAccount, AccountWithLock toAccount, int amonut) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.id = id;
        this.amount = amonut;
    }

    /**
     * Execution run() method of transfer
     */
    @Override
    public void run() {
        int transferAttempts = 3;
        while (transferAttempts > 0) {
            if (fromAccount.transfer(fromAccount, toAccount, amount) == true) {;
                System.out.println("After Transfer #" + id + " First account=" + fromAccount.id + " balance now=" + fromAccount.balance);
                System.out.println("After Transfer #" + id + " second account=" + toAccount.id + " balance now=" + toAccount.balance);
                break;
            }
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(500));
            } catch (InterruptedException e) {
            }
        }
    }

}
