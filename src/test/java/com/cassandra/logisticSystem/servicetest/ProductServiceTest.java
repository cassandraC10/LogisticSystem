package com.cassandra.logisticSystem.servicetest;

import com.cassandra.logisticSystem.data.model.Product;
import com.cassandra.logisticSystem.data.repository.ProductRepository;
import com.cassandra.logisticSystem.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    public void testGetAllProducts() {
        List<Product> products = Arrays.asList(
                new Product(1L, "Product 1", 10.0),
                new Product(2L, "Product 2", 15.0)
        );
        when(productRepository.findAll()).thenReturn(products);

        List<Product> result = productService.getAllProducts();

        assertEquals(2, result.size());
        assertEquals("Product 1", result.get(0).getName());
        assertEquals(Double.valueOf(15.0), result.get(1).getPrice());

        verify(productRepository, times(1)).findAll();
    }

}

