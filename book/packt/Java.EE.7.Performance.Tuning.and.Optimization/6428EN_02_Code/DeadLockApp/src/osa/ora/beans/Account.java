/*
 * Written by Osama Oransa
 * This project is written for the book
 * Java Enterprise Edition 7 Performance Tuning (EN6428)
 */
package osa.ora.beans;

/**
 * @author Osama Oransa
 */
public class Account {

    public double balance;
    public int id;

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
    boolean transfer(Account fromAccount, Account toAccount, double amount) {
        synchronized (fromAccount) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
            }
            synchronized (toAccount) {
                if (fromAccount.withdraw(amount)) {
                    toAccount.deposit(amount);
                }
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                }
            }
            return true;
        }
    }
}
