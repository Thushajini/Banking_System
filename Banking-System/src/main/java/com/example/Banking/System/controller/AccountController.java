package com.example.Banking.System.controller;

import com.example.Banking.System.dto.AccountDTO;
import com.example.Banking.System.model.Account;
import com.example.Banking.System.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/accounts")
public class AccountController {
    private AccountService accountService;
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }



    @PostMapping
public ResponseEntity<Account> createAccount(@RequestBody AccountDTO accountDTO){
    Account account = accountService.createAccount(accountDTO);
    return ResponseEntity.ok(account);
}

@GetMapping("/{id}")
public ResponseEntity<Account> getAccountById(@PathVariable Long id){
        Account account = accountService.getAccountById(id);
        return ResponseEntity.ok(account);
}
@GetMapping("/number/{accountnumber}")

public ResponseEntity<Account> getAccountByNumber(@PathVariable String accountNumber){
        Account account = accountService.getAccountByNumber(accountNumber);
        return ResponseEntity.ok(account);
}

@GetMapping
public ResponseEntity<List<Account>> getAllAccounts(){
        List<Account> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
}

@DeleteMapping("/{id}")
public void deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
}
}
