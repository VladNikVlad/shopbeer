package com.gmail.vladyslavnicko.beerstore.dto;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class CategoriesDTO {
    private Long id;
    private String title;

    public CategoriesDTO() {
    }

    public CategoriesDTO(String title) {
        this.title = title;
    }

    public CategoriesDTO(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public static CategoriesDTO of(String title){
        return new CategoriesDTO(title);
    }
}
