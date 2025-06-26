package com.example.Banking.System.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Users")
public class User {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String role;

    @OneToOne
    @JoinColumn(name="customer_id")
    private Customer customer;


}
