/*
 * Written by Osama Oransa
 * This project is written for the book
 * Java Enterprise Edition 7 Performance Tuning (EN6428)
 */
package osa.ora;

import osa.ora.beans.AccountWithLock;
import osa.ora.beans.TransferLock;

/**
 * @author Osama Oransa
 */
public class BankOperationWithLock {

    /**
     * main method
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BankOperationWithLock bankTransfer = new BankOperationWithLock();
        bankTransfer.settleTransfers();
    }

    /**
     * settleTransfers method It run execute 2 concurrent transfers from same
     * to/from accounts
     */
    public void settleTransfers() {
        AccountWithLock firstAccount = new AccountWithLock();
        firstAccount.balance = 1000;
        firstAccount.id = 101;
        AccountWithLock secondAccount = new AccountWithLock();
        secondAccount.balance = 1000;
        secondAccount.id = 102;
        System.out.println("First account=" + firstAccount.id + " balance=" + firstAccount.balance);
        System.out.println("Second account=" + secondAccount.id + " balance=" + secondAccount.balance);
        TransferLock transfer1 = new TransferLock(1, firstAccount, secondAccount, 200);
        TransferLock transfer2 = new TransferLock(2, secondAccount, firstAccount, 150);
        Thread t1 = new Thread(transfer1);
        Thread t2 = new Thread(transfer2);
        t1.start();
        t2.start();
    }
}
