package com.example.invoicemgtsystembackend.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.invoicemgtsystembackend.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer,Long>{
    
}
