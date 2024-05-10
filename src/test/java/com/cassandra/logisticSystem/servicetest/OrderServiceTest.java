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
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    @Test
    public void testPlaceOrder() {
        Order testOrder = new Order();
        testOrder.setStatus("Pending");
        testOrder.setTotalPrice(100.0);
        testOrder.setShippingAddress("123 John Street");
        testOrder.setOrderDate(new Date());

        when(orderRepository.save(any(Order.class))).thenReturn(testOrder);

        Order placedOrder = orderService.saveOrUpdateOrder(testOrder);

        assertNotNull(placedOrder);
        assertEquals("Pending", placedOrder.getStatus());
        assertEquals(100.0, placedOrder.getTotalPrice());
        assertEquals("123 John Street", placedOrder.getShippingAddress());

        verify(orderRepository, times(1)).save(any(Order.class));
    }

    @Test
    public void testGetAllOrders() {
        List<Order> orders = Arrays.asList(
                new Order(1L, null, null, "Pending", 100.0, "123 John Street", new Date()),
                new Order(2L, null, null, "Processing", 150.0, "456 Peter Street", new Date())
        );

        when(orderRepository.findAll()).thenReturn(orders);

        List<Order> result = orderService.getAllOrders();

        assertEquals(2, result.size());
        assertEquals("Pending", result.get(0).getStatus());
        assertEquals("456 Peter Street", result.get(1).getShippingAddress());

        verify(orderRepository, times(1)).findAll();
    }

}



