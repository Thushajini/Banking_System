package com.example.Banking.System.dto;

import com.example.Banking.System.model.Account;
import lombok.Data;

@Data
public class AccountDTO {
    private Long customerId;
    private Account.AccountType accountType;
}
