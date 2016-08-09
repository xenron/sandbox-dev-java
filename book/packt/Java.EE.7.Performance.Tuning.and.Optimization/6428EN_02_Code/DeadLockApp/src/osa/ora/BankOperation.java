/*
 * Written by Osama Oransa
 * This project is written for the book
 * Java Enterprise Edition 7 Performance Tuning (EN6428)
 */
package osa.ora;

import osa.ora.beans.Account;
import osa.ora.beans.Transfer;

/**
 * @author Osama Oransa
 */
public class BankOperation {

    /**
     * main method
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BankOperation bankTransfer = new BankOperation();
        bankTransfer.settleTransfers();
    }

    /**
     * Settle transfers methods It runs 2 concurrent transfers from-to same 2
     * accounts
     */
    public void settleTransfers() {
        Account firstAccount = new Account();
        firstAccount.balance = 1000;
        firstAccount.id = 101;
        Account secondAccount = new Account();
        secondAccount.balance = 1000;
        secondAccount.id = 102;
        System.out.println("First account=" + firstAccount.id + " balance=" + firstAccount.balance);
        System.out.println("Second account=" + secondAccount.id + " balance=" + secondAccount.balance);
        Transfer transfer1 = new Transfer(1, firstAccount, secondAccount, 200);
        Transfer transfer2 = new Transfer(2, secondAccount, firstAccount, 150);
        Thread t1 = new Thread(transfer1);
        Thread t2 = new Thread(transfer2);
        t1.start();
        t2.start();
    }
}
