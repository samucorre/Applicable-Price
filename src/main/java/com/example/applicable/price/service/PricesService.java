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
     * Obtiene los precios aplicables.
     *
     * @param brandId         Id de la marca.
     * @param productId       Id del producto.
     * @param applicationDate Fecha y hora para la consulta.
     * @return Lista de precios aplicables ordenados por prioridad descendente.
     */
    public List<Prices> getApplicablePrices(Long brandId, Long productId, LocalDateTime applicationDate) {
        return pricesRepository.findApplicablePrices(
                brandId, productId, applicationDate, applicationDate);
    }
}
