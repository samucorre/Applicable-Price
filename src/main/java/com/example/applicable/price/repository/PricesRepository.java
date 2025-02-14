package com.example.applicable.price.repository;

import com.example.applicable.price.model.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PricesRepository extends JpaRepository<Prices, Long> {

    /**
     * Retrieves the applicable prices for a product.
     *
     * @param brandId   Brand identifier.
     * @param productId Product identifier.
     * @param startDate Start date and time for application.
     * @param endDate   End date and time for application.
     * @return List of applicable prices, ordered by priority from highest to lowest.
     */
    @Query("SELECT p FROM Prices p WHERE p.brandId = :brandId AND p.productId = :productId AND p.startDate <= :startDate AND p.endDate >= :endDate ORDER BY p.priority DESC")
    List<Prices> findApplicablePrices(
            @Param("brandId") Long brandId,
            @Param("productId") Long productId,
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate);
}

