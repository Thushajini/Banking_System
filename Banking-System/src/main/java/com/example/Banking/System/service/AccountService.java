package com.example.Banking.System.service;

import com.example.Banking.System.dto.AccountDTO;
import com.example.Banking.System.model.Account;

import java.util.List;

public interface AccountService {
    Account createAccount(AccountDTO accountDTO);

    Account getAccountById(Long id);

    Account getAccountByNumber(String accountNumber);

    List<Account> getAllAccounts();

    void deleteAccount(Long id);
}
