package com.example.invoicemgtsystembackend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.invoicemgtsystembackend.exceptionHandler.GenericException;
import com.example.invoicemgtsystembackend.model.Invoice;
import com.example.invoicemgtsystembackend.repo.InvoiceRepo;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepo invoiceRepo;

    public ResponseEntity<List<Invoice>> getInvoices(Integer pageNo, Integer pageSize){
        return new ResponseEntity<>(invoiceRepo.findAll(PageRequest.of(pageNo, pageSize)).getContent(), HttpStatus.OK);
    }

    public ResponseEntity<String> saveInvoice (Invoice invoice){
        invoice.setDate(new Date());
        invoiceRepo.save(invoice);
        return new ResponseEntity<>("Invoice Saved Successfully", HttpStatus.CREATED);
    }

    public ResponseEntity<Invoice> getInvoiceById (Long invoiceId){
        Invoice invoice = invoiceRepo.findById(invoiceId).orElseThrow(()->new GenericException("Invoice not found with id :"+invoiceId, HttpStatus.NOT_FOUND));
        return new ResponseEntity<>(invoice, HttpStatus.CREATED);
    }

    public ResponseEntity<String>updateInvoice(Invoice invoice,Long invoiceId){
        invoice.setDate(new Date());
        Invoice prevInvoice = invoiceRepo.findById(invoiceId).orElseThrow(()->new GenericException("Invoice not found with id :"+invoiceId, HttpStatus.NOT_FOUND));
        Invoice response = invoiceRepo.save(invoice);
        return new ResponseEntity<>("Invoice Updated Successfully",HttpStatus.OK);
    }

    public ResponseEntity<String>deleteInvoice(Long invoiceId){
        Invoice prevInvoice = invoiceRepo.findById(invoiceId).orElseThrow(()->new GenericException("Invoice not found with id :"+invoiceId, HttpStatus.NOT_FOUND));
        invoiceRepo.deleteById(invoiceId);
        return new ResponseEntity<>("Invoice Deleted Successfully",HttpStatus.OK);
    }
}
