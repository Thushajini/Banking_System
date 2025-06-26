package com.example.Banking.System.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phoneNumber;

    @OneToOne(mappedBy = "customer",cascade = CascadeType.ALL)
    private User user;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<Account> accounts;

}
