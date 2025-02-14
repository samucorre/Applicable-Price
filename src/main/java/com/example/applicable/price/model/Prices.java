package com.example.applicable.price.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "prices")
@Data

@NoArgsConstructor
@AllArgsConstructor
public class Prices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @Column(name = "brand_id", nullable = false)
    @JsonProperty("brandId")
    private Long brandId;

    @Column(name = "start_date", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("startDate")
    private LocalDateTime startDate;

    @Column(name = "end_date", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("endDate")
    private LocalDateTime endDate;

    @Column(name = "price_list", nullable = false)
    @JsonProperty("priceList")
    private Long priceList;

    @Column(name = "product_id", nullable = false)
    @JsonProperty("productId")
    private Long productId;

    @Column(name = "priority", nullable = false)
    @JsonProperty("priority")
    private Integer priority;

    @Column(name = "price", nullable = false)
    @JsonProperty("price")
    private double price;

    @Column(name = "curr", nullable = false)
    @JsonProperty("curr")
    private String curr;

}