package com.example.Banking.System.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  double amount;
    private String description;
    private LocalDateTime transactionDate;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
    @ManyToOne
    @JoinColumn(name="toAccount_id")
    private Account toAccount;

    @ManyToOne
    @JoinColumn(name="fromAccount_id")
    private Account fromAccount;

    public enum TransactionType{
        DEPOSIT,WITHDRAWAL,TRANSFER
    }
}
