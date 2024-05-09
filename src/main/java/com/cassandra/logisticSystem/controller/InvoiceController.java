package com.cassandra.logisticSystem.controller;

import com.cassandra.logisticSystem.data.model.Invoice;
import com.cassandra.logisticSystem.data.model.Vehicle;
import com.cassandra.logisticSystem.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoice")
public class InvoiceController {
    private final InvoiceService invoiceService;

    @Autowired
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping
    public ResponseEntity<List<Invoice>> getAllInvoice() {
        List<Invoice> invoices = invoiceService.getAllInvoice();
        return new ResponseEntity<>(invoices, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Invoice> getInvoiceById(@PathVariable Long id) {
        Invoice invoice = invoiceService.getInvoiceById(id);
        return new ResponseEntity<>(invoice, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Invoice> createOrUpdateInvoice(@RequestBody Invoice invoice) {
        Invoice savedInvoice = invoiceService.saveOrUpdateInvoice(invoice);
        return new ResponseEntity<>(savedInvoice, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long id) {
        invoiceService.deleteInvoice(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
