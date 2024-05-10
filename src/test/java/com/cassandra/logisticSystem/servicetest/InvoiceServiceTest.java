package com.cassandra.logisticSystem.servicetest;

import com.cassandra.logisticSystem.data.model.Invoice;
import com.cassandra.logisticSystem.data.model.Order;
import com.cassandra.logisticSystem.data.repository.InvoiceRepository;
import com.cassandra.logisticSystem.data.repository.OrderRepository;
import com.cassandra.logisticSystem.service.InvoiceService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Date;
import java.util.Optional;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class InvoiceServiceTest {
    @Mock
    private InvoiceRepository invoiceRepository;

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private InvoiceService invoiceService;
    @Test
    public void testGenerateInvoice() {

        Order testOrder = new Order();
        testOrder.setStatus("Completed");
        testOrder.setTotalPrice(200.0);


        when(orderRepository.findById(anyLong())).thenReturn(Optional.of(testOrder));

        Invoice generatedInvoice = invoiceService.generateInvoice(1L);

        assertNotNull(generatedInvoice);
        assertEquals(testOrder.getTotalPrice(), generatedInvoice.getTotalAmount());
        assertEquals("Completed", generatedInvoice.getOrder().getStatus());

    }


}
