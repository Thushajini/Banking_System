package com.example.Banking.System.service;

import com.example.Banking.System.dto.CustomerDTO;
import com.example.Banking.System.model.Customer;

import java.util.List;


public interface CustomerService {
    Customer createCustomer(CustomerDTO customerDTO);

    List<Customer> getAllCustomers();

    Customer getCustomerById(Long id);

    Customer updateCustomer(CustomerDTO customerDTO, long id);

    void deleteCustomer(Long id);
}
