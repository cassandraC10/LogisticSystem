package com.cassandra.logisticSystem.controllertest;

import com.cassandra.logisticSystem.controller.OrderController;
import com.cassandra.logisticSystem.data.model.Order;
import com.cassandra.logisticSystem.service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrderControllerTest {

    @Mock
    private OrderService orderService;

    @InjectMocks
    private OrderController orderController;

    @Test
    public void testGetAllOrders() {
        // Mock data
        List<Order> orders = Arrays.asList(
                new Order(1L, null, null, "Pending", 100.0, "123 Main St", new Date()),
                new Order(2L, null, null, "Processing", 150.0, "456 Oak St", new Date())
        );

        when(orderService.getAllOrders()).thenReturn(orders);

        // Call controller method
        ResponseEntity<List<Order>> response = orderController.getAllOrders();

        // Verify response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());
        assertEquals("Pending", response.getBody().get(0).getStatus());
        assertEquals("456 Oak St", response.getBody().get(1).getShippingAddress());

        // Verify that getAllOrders() method of orderService is called exactly once
        verify(orderService, times(1)).getAllOrders();
    }

    // Add more test cases for other controller methods
}
