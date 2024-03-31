package com.example.invoicemgtsystembackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.invoicemgtsystembackend.exceptionHandler.GenericException;
import com.example.invoicemgtsystembackend.model.Customer;
import com.example.invoicemgtsystembackend.repo.CustomerRepo;

@Service
public class CustomerService {

    @Autowired 
    private CustomerRepo customerRepo;

    public ResponseEntity<List<Customer>> getCustomerList(Integer pageNo, Integer pageSize){
        return new ResponseEntity<>(customerRepo.findAll(PageRequest.of(pageNo, pageSize)).getContent(),HttpStatus.OK);
    }
    public ResponseEntity<String> saveCustomer(Customer customer){
        customerRepo.save(customer);
        return new ResponseEntity<>("Customer saved succesfully",HttpStatus.CREATED);
    }
    
    public ResponseEntity<String> findCustomerById(Long customerId){
        customerRepo.findById(customerId).orElseThrow(()->new GenericException("Customer not found with id : "+customerId, HttpStatus.NOT_FOUND));
        return new ResponseEntity<>("Customer saved succesfully",HttpStatus.OK);
    }

    public ResponseEntity<String> updateCustomer(Customer customer,Long customerId){
        customerRepo.findById(customerId).orElseThrow(()->new GenericException("Customer not found with id : "+customerId, HttpStatus.NOT_FOUND));
        customerRepo.save(customer);
        return new ResponseEntity<>("Customer updated succesfully",HttpStatus.OK);
    }


    public ResponseEntity<String> deleteCustomer(Long customerId){
        customerRepo.findById(customerId).orElseThrow(()->new GenericException("Customer not found with id : "+customerId, HttpStatus.NOT_FOUND));
        customerRepo.deleteById(customerId);
        return new ResponseEntity<>("Customer deleted succesfully",HttpStatus.OK);
    }
}
