package com.cassandra.logisticSystem.service;

import com.cassandra.logisticSystem.data.model.Invoice;
import com.cassandra.logisticSystem.data.model.Order;
import com.cassandra.logisticSystem.data.repository.InvoiceRepository;
import com.cassandra.logisticSystem.data.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Service
public class InvoiceService {
    private final InvoiceRepository invoiceRepository;
    private final OrderRepository orderRepository;


    @Autowired
    public InvoiceService(InvoiceRepository invoiceRepository, OrderRepository orderRepository) {
        this.invoiceRepository = invoiceRepository;
        this.orderRepository = orderRepository;

    }

    public Invoice generateInvoice(Long orderId) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + orderId));

        Invoice invoice = new Invoice();
        invoice.setOrder(order);
        invoice.setTotalAmount(order.getTotalPrice());

        return invoiceRepository.save(invoice);
    }

    public List<Invoice> getAllInvoice(){
        return invoiceRepository.findAll();
    }

    public Invoice getInvoiceById(Long id){
        return invoiceRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Invoice with id: " + id + "not found"));
    }

    public Invoice saveOrUpdateInvoice(Invoice invoice){
        return invoiceRepository.save(invoice);
    }

    public void deleteInvoice(Long id) {
        invoiceRepository.deleteById(id);
    }
}
