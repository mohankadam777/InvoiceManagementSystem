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

import com.example.invoicemgtsystembackend.model.Invoice;
import com.example.invoicemgtsystembackend.service.InvoiceService;

@RestController
@RequestMapping("/invoices")
@CrossOrigin(origins = "http://localhost:4200")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping
    public ResponseEntity<List<Invoice>> getInvoices(@RequestParam(defaultValue = "0") Integer pageNo, @RequestParam(defaultValue = "10")Integer  pageSize
    ){
        return invoiceService.getInvoices(pageNo,pageSize);
    }

    @PostMapping
    public ResponseEntity<String> saveInvoice(@RequestBody Invoice invoice){
        return invoiceService.saveInvoice(invoice);
    }

    @GetMapping("/{invoiceId}")
    public ResponseEntity<Invoice> getInvoiceById(@PathVariable Long invoiceId){
        System.out.println("incontroller ");
        return invoiceService.getInvoiceById(invoiceId);
    }

    @PutMapping
    public ResponseEntity<String> updateInvoice(@RequestBody Invoice invoice, @RequestParam Long invoiceId){
        return invoiceService.updateInvoice(invoice,invoiceId);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteInvoice(@RequestParam Long invoiceId){
        return invoiceService.deleteInvoice(invoiceId);
    }
    
}
