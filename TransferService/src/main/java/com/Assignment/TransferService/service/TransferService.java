package com.Assignment.TransferService.service;

import com.Assignment.TransferService.model.Account;
import com.Assignment.TransferService.model.Transaction;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class TransferService {
    private final Map<String,
            Account> accounts = new HashMap<>();
    private final List<Transaction> transactions = new ArrayList<>();

    // Create a new account
    public Account createAccount() {
        Account account = new Account();
        accounts.put(account.getAccountNumber(), account);
        return account;
    }

    // Get all accounts
    public List<Account> getAllAccounts() {
        return new ArrayList<>(accounts.values());
    }

    // Transfer money
    public Transaction transfer(String source, String destination, double amount) {
        if (!accounts.containsKey(source) || !accounts.containsKey(destination)) {
            throw new IllegalArgumentException("Invalid account number(s)");
        }
        Account sourceAccount = accounts.get(source);
        Account destinationAccount = accounts.get(destination);

        if (amount <= 0 || sourceAccount.getBalance() < amount) {
            throw new IllegalArgumentException("Insufficient balance or invalid amount");
        }

        sourceAccount.setBalance(sourceAccount.getBalance() - amount);
        destinationAccount.setBalance(destinationAccount.getBalance() + amount);

        Transaction transaction = new Transaction(source, destination, amount);
        transactions.add(transaction);
        return transaction;
    }
}
