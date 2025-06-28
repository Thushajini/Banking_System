package com.example.Banking.System.service.Impl;

import com.example.Banking.System.dto.AccountDTO;
import com.example.Banking.System.model.Account;
import com.example.Banking.System.model.Customer;
import com.example.Banking.System.reposiitory.AccountRepository;
import com.example.Banking.System.reposiitory.CustomerRepository;
import com.example.Banking.System.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;

    public AccountServiceImpl(AccountRepository accountRepository, CustomerRepository customerRepository) {
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
    }
    @Override
    public Account createAccount( AccountDTO accountDTO) {
        Customer customer = customerRepository.findById(accountDTO.getCustomerId())
                .orElseThrow(()->new RuntimeException("Customer not found"));

        Account account = new Account();
        account.setAccountNumber(generateAccountNumber());
        account.setBalance(0);
        account.setAccountType(accountDTO.getAccountType());
        account.setCustomer(customer);
        return accountRepository.save(account);

    }
    @Override public Account getAccountById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Account not found"));
    }
    @Override
    public Account getAccountByNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(()->new RuntimeException("Account not found"));
    }

    @Override
    public List<Account> getAllAccounts() {
    return accountRepository.findAll();
    }

    @Override
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }


    private String generateAccountNumber() {
        Random random = new Random();
        return String.format("%010d",random.nextInt(1_000_000_000));
    }
}
