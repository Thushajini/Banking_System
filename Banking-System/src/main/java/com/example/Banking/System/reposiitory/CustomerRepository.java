package com.example.Banking.System.reposiitory;

import com.example.Banking.System.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
  Customer findByEmail(String email);
}
