package com.example.Banking.System.controller;

import com.example.Banking.System.dto.CustomerDTO;
import com.example.Banking.System.model.Customer;
import com.example.Banking.System.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
    @RequestMapping("/api/customers")

    public class CustomerController {

        private CustomerService customerService;

        public CustomerController(CustomerService customerService) {
            this.customerService = customerService;
        }


        @PostMapping
        public ResponseEntity<Customer> createCustomer(@RequestBody CustomerDTO customerDTO)
        {
            Customer customer = customerService.createCustomer(customerDTO);
            return  ResponseEntity.ok(customer);
        }
@GetMapping
        public ResponseEntity<List<Customer>> getAllCustomers(){
            List<Customer> customer = customerService.getAllCustomers();
            return ResponseEntity.ok(customer);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long customerId){
            Customer customer = customerService.getCustomerById(customerId);
            return ResponseEntity.ok(customer);
        }
@PutMapping("/{id}")
        public ResponseEntity<Customer> updateCustomer(@RequestBody CustomerDTO customerDTO,@PathVariable long id){
            Customer customer = customerService.updateCustomer(customerDTO,id);
            return ResponseEntity.ok(customer);
        }

        @DeleteMapping("/{id}")
        public void deleteCustomer(@PathVariable Long id){
            customerService.deleteCustomer(id);
        }
    }


