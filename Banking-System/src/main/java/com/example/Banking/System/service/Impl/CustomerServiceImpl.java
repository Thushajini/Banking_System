package com.example.Banking.System.service.Impl;

import com.example.Banking.System.dto.CustomerDTO;
import com.example.Banking.System.model.Customer;
import com.example.Banking.System.reposiitory.CustomerRepository;
import com.example.Banking.System.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer createCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
         customer.setFirstName(customerDTO.getFirstName());
          customer.setLastName(customerDTO.getLastName());
          customer.setEmail(customerDTO.getEmail());
          customer.setAddress(customerDTO.getAddress());
          customer.setPhoneNumber(customerDTO.getPhoneNumber());
      return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id){
        return customerRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Customer not found") );
    }

    @Override
    public Customer updateCustomer(CustomerDTO customerDTO, long id) {
        Customer customer =customerRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Customer not found"));

        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        customer.setEmail(customerDTO.getEmail());
        customer.setPhoneNumber(customerDTO.getPhoneNumber());
        customer.setAddress(customerDTO.getAddress());

        return customerRepository.save(customer);
    }

    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }
}
