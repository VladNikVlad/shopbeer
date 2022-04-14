package com.gmail.vladyslavnicko.beerstore.dto;

import lombok.Data;

@Data
public class AddressDTO {
    private Long id;

    private String country;
    private String region;
    private String city;
    private String street;
    private int numberBuilding;
    private int apartment;

    public AddressDTO() {
    }

    public AddressDTO(String country, String region, String city, String street, int numberBuilding, int apartment) {
        this.country = country;
        this.region = region;
        this.city = city;
        this.street = street;
        this.numberBuilding = numberBuilding;
        this.apartment = apartment;
    }

    public static AddressDTO of(String country, String region, String city, String street, int numberBuilding, int apartment) {
        return new AddressDTO(country, region, city, street, numberBuilding, apartment);
    }
}
