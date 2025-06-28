package com.example.Banking.System.service;

import com.example.Banking.System.model.Transaction;

import java.util.List;

public interface TransactionService {
    Transaction deposit(String accountNumber, double amount);

    Transaction withdrawal(double amount, String accountNumber);

    Transaction transfer(String toAccountNumber, String fromAccountNumber, double amount);

    List<Transaction> getAccountTransction(String accountNumber);
}
