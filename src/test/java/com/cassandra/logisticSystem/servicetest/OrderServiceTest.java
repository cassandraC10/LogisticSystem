package com.cassandra.logisticSystem.servicetest;

import com.cassandra.logisticSystem.data.model.Order;
import com.cassandra.logisticSystem.data.repository.OrderRepository;
import com.cassandra.logisticSystem.service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    @Test
    public void testGetAllOrders() {
        // Mock data
        List<Order> orders = Arrays.asList(
                new Order(1L, null, null, "Pending", 100.0, "123 Main St", new Date()),
                new Order(2L, null, null, "Processing", 150.0, "456 Oak St", new Date())
        );

        when(orderRepository.findAll()).thenReturn(orders);

        // Call service method
        List<Order> result = orderService.getAllOrders();

        // Verify result
        assertEquals(2, result.size());
        assertEquals("Pending", result.get(0).getStatus());
        assertEquals("456 Oak St", result.get(1).getShippingAddress());

        // Verify that findAll() method of orderRepository is called exactly once
        verify(orderRepository, times(1)).findAll();
    }

    // Add more test cases for other service methods
}
