package com.gmail.vladyslavnicko.beerstore.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDTO {
    private Long id;

    private String title;
    private BigDecimal price;

    public ProductDTO() {
    }

    public ProductDTO(String title, BigDecimal price) {
        this.title = title;
        this.price = price;
    }

    public static ProductDTO of(String title, BigDecimal price){
        return new ProductDTO(title,price);
    }
}
