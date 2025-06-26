package com.example.Banking.System.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountNumber;
    private double balance;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @OneToMany(mappedBy = "fromAccount" , cascade = CascadeType.ALL)
    private List<Transaction> outgoingTransactions;

    @OneToMany(mappedBy = "toAccount" , cascade = CascadeType.ALL)
    private List<Transaction> incomingTransactions;
    @ManyToOne
    @JoinColumn(name ="customer_Id")
    private Customer customer;

    public enum AccountType{
        SAVINGS,CURRENT,FIXED_DEPOSIT
    }
}
