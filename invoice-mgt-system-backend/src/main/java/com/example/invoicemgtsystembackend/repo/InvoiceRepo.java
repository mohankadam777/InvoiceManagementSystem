package com.example.invoicemgtsystembackend.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.invoicemgtsystembackend.model.Invoice;

public interface InvoiceRepo extends JpaRepository<Invoice,Long>{
    
}
