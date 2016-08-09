package com.company.customer;

import java.math.BigDecimal;
import java.util.Locale;

public class Customer {

    private String name;
    private int accountNumber;
    private Locale locale;
    private BigDecimal balance;

    public Customer() {
        this.name = "Default Customer";
        this.accountNumber = 12345;
        this.locale = Locale.ITALY;
        this.balance = new BigDecimal("0");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if (name == null) {
            throw new IllegalArgumentException("Names must not be null");
        } else {
            this.name = name;
        }
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = new BigDecimal(balance);
    }

    public String toString() {
        java.text.NumberFormat format =
                java.text.NumberFormat.getCurrencyInstance(locale);
        StringBuilder value = new StringBuilder();
        value.append(String.format("Name: %s%n", this.name));
        value.append(String.format("Account Number: %d%n", this.accountNumber));
        value.append(String.format("Balance: %s%n", format.format(this.balance)));
        return value.toString();
    }
}
