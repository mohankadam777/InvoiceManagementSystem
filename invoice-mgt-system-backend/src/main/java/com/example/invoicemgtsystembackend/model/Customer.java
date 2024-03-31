package com.example.invoicemgtsystembackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @Column(name ="cust_name", nullable = false)
    private String custName;

    @Column(name ="email", nullable = false,unique = true)
    private String email;

    @Column(name ="contact_number", nullable = false)
    private String contactNumber;
    
    @Column(name ="address", nullable = false)
    private String address; 
    
}
