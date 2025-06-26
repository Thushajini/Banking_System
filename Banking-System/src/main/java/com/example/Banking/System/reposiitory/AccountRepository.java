package com.example.Banking.System.reposiitory;

import com.example.Banking.System.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
    Account findByAccountNumber(String accountNumber);
}
