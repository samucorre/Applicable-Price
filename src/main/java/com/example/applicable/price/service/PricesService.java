package com.example.applicable.price.service;

import com.example.applicable.price.model.Prices;
import com.example.applicable.price.repository.PricesRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PricesService {

    private final PricesRepository pricesRepository;

    public PricesService(PricesRepository pricesRepository) {
        this.pricesRepository = pricesRepository;
    }

    /**
     * Retrieves applicable prices.
     *
     * @param brandId         Brand ID.
     * @param productId       Product ID.
     * @param applicationDate Date and time for the query.
     * @return List of applicable prices sorted by descending priority.
     */
    public List<Prices> getApplicablePrices(Long brandId, Long productId, LocalDateTime applicationDate) {
        return pricesRepository.findApplicablePrices(
                brandId, productId, applicationDate, applicationDate);
    }
}
