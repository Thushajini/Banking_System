package com.example.Banking.System.service.Impl;

import com.example.Banking.System.model.Account;
import com.example.Banking.System.model.Transaction;
import com.example.Banking.System.reposiitory.AccountRepository;
import com.example.Banking.System.reposiitory.TransactionRepository;
import com.example.Banking.System.service.TransactionService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service

public class TransactionServiceImpl implements TransactionService {
private TransactionRepository transactionRepository;
private AccountRepository accountRepository;


    public TransactionServiceImpl(TransactionRepository transactionRepository, AccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public Transaction deposit(String accountNumber, double amount) {
        Account account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(()->new RuntimeException("Account not found"));
        double newBalance = account.getBalance() + amount;
        account.setBalance(newBalance);
        accountRepository.save(account);

        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setTransactionDate(LocalDateTime.now());
        transaction.setDescription("Deposit");
        transaction.setToAccount(account);
        transaction.setTransactionType(Transaction.TransactionType.DEPOSIT);

        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction withdrawal(double amount, String accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(()->new RuntimeException("Account not found"));

        double newBalance = account.getBalance() - amount;
        account.setBalance(newBalance);
        accountRepository.save(account);

        Transaction transaction =new Transaction();
        transaction.setAmount(amount);
        transaction.setDescription("withdrawal");
        transaction.setTransactionDate(LocalDateTime.now());
        transaction.setFromAccount(account);
        transaction.setTransactionType(Transaction.TransactionType.WITHDRAWAL);

        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction transfer(String toAccountNumber, String fromAccountNumber, double amount) {
        Account fromAccount = accountRepository.findByAccountNumber(fromAccountNumber)
                .orElseThrow(()->new RuntimeException("from Account not found"));

        Account toAccount = accountRepository.findByAccountNumber(toAccountNumber)
                .orElseThrow(()->new RuntimeException("toAccount not found"));

        if(fromAccount.getBalance()< amount){
            throw new RuntimeException(("Insufficient balance"));
        }

        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);

        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setDescription("Transfer to"+toAccountNumber);
        transaction.setTransactionDate(LocalDateTime.now());
        transaction.setToAccount(toAccount);
        transaction.setFromAccount(fromAccount);
        transaction.setTransactionType(Transaction.TransactionType.TRANSFER);

        return transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> getAccountTransction(String accountNumber){
        return transactionRepository.findByFromAccount_AccountNumberOrToAccount_AccountNumber(accountNumber,accountNumber);
    }


}
