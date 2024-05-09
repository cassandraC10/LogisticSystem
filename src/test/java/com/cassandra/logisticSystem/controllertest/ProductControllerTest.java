package com.cassandra.logisticSystem.controllertest;

import com.cassandra.logisticSystem.controller.ProductController;
import com.cassandra.logisticSystem.data.model.Product;
import com.cassandra.logisticSystem.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    private MockMvc mockMvc;

    @Test
    public void testGetAllProducts() throws Exception {
        // Mock data
        List<Product> products = Arrays.asList(
                new Product(1L, "Product 1", 10.0),
                new Product(2L, "Product 2", 15.0)
        );
        when(productService.getAllProducts()).thenReturn(products);

        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();

        mockMvc.perform(get("/api/products"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("Product 1"))
                .andExpect(jsonPath("$[0].price").value(10.0))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name").value("Product 2"))
                .andExpect(jsonPath("$[1].price").value(15.0));

        verify(productService, times(1)).getAllProducts();
    }

}

