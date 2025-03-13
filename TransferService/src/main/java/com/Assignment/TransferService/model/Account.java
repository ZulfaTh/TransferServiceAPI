package com.Assignment.TransferService.model;

import lombok.Data;
import java.util.UUID;

@Data
public class Account {
    private String accountNumber;
    private double balance;

    public Account() {
        this.accountNumber = UUID.randomUUID().toString(); // Generate unique account number
        this.balance = 1000.0; // Default balance
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
