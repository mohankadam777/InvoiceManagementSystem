package com.example.invoicemgtsystembackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.invoicemgtsystembackend.model.Customer;
import com.example.invoicemgtsystembackend.service.CustomerService;

@RestController
@RequestMapping("/customers")
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;


    @GetMapping
    public ResponseEntity<List<Customer>> getCustomer(@RequestParam(defaultValue = "0") Integer pageNo, @RequestParam(defaultValue = "10")Integer  pageSize){
        return customerService.getCustomerList(pageNo,pageSize);
    }

    @PostMapping
    public ResponseEntity<String> saveCustomer(@RequestBody Customer customer){
        return customerService.saveCustomer(customer);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<String> findCustomerById(@PathVariable Long customerId){
        return customerService.findCustomerById(customerId);
    }


    @PutMapping
    public ResponseEntity<String> updateCustomer(@RequestBody Customer customer,@RequestParam Long customerId){
        return customerService.updateCustomer(customer, customerId);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteCustomer(@RequestParam Long customerId){
        return customerService.deleteCustomer(customerId);
    }
}
