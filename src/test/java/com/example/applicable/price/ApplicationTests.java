package com.example.applicable.price;

import com.example.applicable.price.model.Prices;
import com.example.applicable.price.repository.PricesRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private ApplicationContext context;

    @Test
    void contextLoads() {
        assertNotNull(context, "The application context should have been loaded.");
    }

    // Verifica el bean de PricesController
    @Test
    void pricesControllerBeanExists() {
        assertNotNull(context.getBean("pricesController"), "The PricesController bean should exist in the context.");
    }

    // Verifica el bean de PricesService
    @Test
    void priceServiceBeanExists() {
        assertNotNull(context.getBean("pricesService"), "The PricesService bean should exist in the application context.");
    }

    // Verifica el bean de PricesRepository
    @Test
    void pricesRepositoryBeanExists() {
        assertNotNull(context.getBean("pricesRepository"), "The PricesRepository bean should exist in the application context.");
    }

    //Verificar realización de consultas
    @Autowired
    private PricesRepository pricesRepository;

    @Test
    void pricesRepositoryCanFetchData() {
        Long brandId = 1L;
        Long productId = 35455L;
        LocalDateTime date = LocalDateTime.of(2020, 6, 14, 10, 0);

        List<Prices> prices = pricesRepository.findApplicablePrices(brandId, productId, date, date);

        assertNotNull(prices, "The query should not return null.");
        assertFalse(prices.isEmpty(), "There should be at least one price in the database.");
    }

}