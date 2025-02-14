package com.example.applicable.price.controller;

import com.example.applicable.price.model.Prices;
import com.example.applicable.price.service.PricesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/prices")
public class PricesController {

    private final PricesService pricesService;

    public PricesController(PricesService pricesService) {
        this.pricesService = pricesService;
    }

    /**
     * Retrieves the applicable prices for a product of a brand at a specific date and time.
     *
     * @param brandId            Brand ID.
     * @param productId          Product ID.
     * @param applicationDateStr Date and time in the format "yyyy-MM-dd HH:mm:ss".
     * @return List of applicable prices ordered by descending priority.
     */
    @GetMapping
    public ResponseEntity<Object> getPrice(
            @RequestParam("applicationDate") String applicationDateStr,
            @RequestParam("productId") Long productId,
            @RequestParam("brandId") Long brandId) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime applicationDate = LocalDateTime.parse(applicationDateStr, formatter);
        List<Prices> applicablePrices = pricesService.getApplicablePrices(brandId, productId, applicationDate);

        if (!applicablePrices.isEmpty()) {
            return ResponseEntity.ok(applicablePrices);
        } else {
            return ResponseEntity.status(404).body("No applicable price found.");
        }
    }
}
