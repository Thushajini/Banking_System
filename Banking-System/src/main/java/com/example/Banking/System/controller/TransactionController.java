package com.example.Banking.System.controller;

import com.example.Banking.System.model.Transaction;
import com.example.Banking.System.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {
    private TransactionService transactionService;

    @PostMapping("/deposit")
    public ResponseEntity<Transaction> deposit(@RequestParam double amount,@RequestParam String accountNumber){
        Transaction transaction = transactionService.deposit(accountNumber,amount);
        return ResponseEntity.ok(transaction);
    }
@PostMapping("/withdraw")
    public ResponseEntity<Transaction> withdrawal(@RequestParam double amount,@RequestParam String accountNumber){
        Transaction transaction = transactionService.withdrawal(amount,accountNumber);
        return ResponseEntity.ok(transaction);
    }

    @PostMapping("/transfer")
    public ResponseEntity<Transaction> transfer(@RequestParam String fromAccountNumber,@RequestParam String toAccountNumber,@RequestParam double amount){
        Transaction transaction = transactionService.transfer(toAccountNumber,fromAccountNumber,amount);
    return ResponseEntity.ok(transaction);
    }

    @GetMapping("/account/{accountNumber}")
    public ResponseEntity<List<Transaction>> getAccountTransactions(@PathVariable String accountNumber){
        List<Transaction> transactions = transactionService.getAccountTransction(accountNumber);
        return ResponseEntity.ok(transactions);
    }

}
