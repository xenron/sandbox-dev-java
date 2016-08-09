/*
 * Written by Osama Oransa
 * This project is written for the book
 * Java Enterprise Edition 7 Performance Tuning (EN6428)
 */
package osa.ora.beans;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Osama Oransa
 */
public class AccountWithLock {

    public double balance;
    public int id;
    public ReentrantLock lock = new ReentrantLock();

    /**
     * withdraw method , it check the balance is sufficient before proceeding
     * with withdraw
     *
     * @param amount
     * @return boolean true/false indicating successful or failed transfer
     */
    boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Deposit method to add money to this account
     *
     * @param amount
     */
    void deposit(double amount) {
        balance += amount;
    }

    /**
     * Transfer money amount from fromAccount to toAccount
     *
     * @param fromAccount
     * @param toAccount
     * @param amount
     * @return boolean true/false if transfer successful or not
     */
    boolean transfer(AccountWithLock fromAccount, AccountWithLock toAccount, double amount) {
        System.out.println("Try to obtain lock for accountFrom trial ");
        try {
            fromAccount.lock.tryLock(3, TimeUnit.SECONDS);
        } catch (InterruptedException ex) {
            Logger.getLogger(AccountWithLock.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
        }
        if (fromAccount.lock.isHeldByCurrentThread() == false) {
            System.out.println("Failed to obtain lock for From");
            return false;
        }
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
        }
        System.out.println("Try to obtain lock for account To trial");
        try {
            toAccount.lock.tryLock(3, TimeUnit.SECONDS);
        } catch (InterruptedException ex) {
            Logger.getLogger(AccountWithLock.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (!toAccount.lock.isHeldByCurrentThread()) {
            fromAccount.lock.unlock();
            return false;
        }
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
        }
        if (fromAccount.withdraw(amount)) {
            toAccount.deposit(amount);
            fromAccount.lock.unlock();
            toAccount.lock.unlock();
        }
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
        }
        return true;
    }
}
