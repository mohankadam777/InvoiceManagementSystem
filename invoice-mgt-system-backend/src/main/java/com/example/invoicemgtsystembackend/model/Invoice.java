package com.example.invoicemgtsystembackend.model;




import java.util.Date;
import java.util.List;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invoiceNumber;

    @Column(name="date")
    private Date date;  

    @Column(name="product_details",columnDefinition = "jsonb",nullable = false)
    @JdbcTypeCode(SqlTypes.JSON)
    private List<ProductDetails> productDetails;

    @Column(name="amount",nullable = false,unique = true)
    private Integer amount;

    @ManyToOne(targetEntity = Customer.class,fetch = FetchType.EAGER)
    @JoinColumn(name =  "customer_id",
     insertable = false,updatable = false
     )
    private Customer customer;

    @Column(name ="customer_id" )
    private Long customerId;

}
