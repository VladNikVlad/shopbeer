package com.gmail.vladyslavnicko.beerstore.model;

import com.gmail.vladyslavnicko.beerstore.dto.AddressDTO;

import javax.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue
    private Long id;

    private String country;
    private String region;
    private String city;
    private String street;
    private int numberBuilding;
    private int apartment;


    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    public Address() {
    }


    public Address(String country, String region, String city, String street, int numberBuilding, int apartment) {
        this.country = country;
        this.region = region;
        this.city = city;
        this.street = street;
        this.numberBuilding = numberBuilding;
        this.apartment = apartment;
    }

    public static Address of(String country, String region, String city, String street, int numberBuilding, int apartment) {
        return new Address(country, region, city, street, numberBuilding, apartment);
    }

    public AddressDTO toDTO() {
        return AddressDTO.of(country, region, city, street, numberBuilding, apartment);
    }

    public static Address fromDTO(AddressDTO addressDTO) {
        return Address.of(addressDTO.getCountry(), addressDTO.getRegion(), addressDTO.getCity(),
                addressDTO.getStreet(), addressDTO.getNumberBuilding(), addressDTO.getApartment());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumberBuilding() {
        return numberBuilding;
    }

    public void setNumberBuilding(int numberBuilding) {
        this.numberBuilding = numberBuilding;
    }

    public int getApartment() {
        return apartment;
    }

    public void setApartment(int apartment) {
        this.apartment = apartment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", region='" + region + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", numberBuilding=" + numberBuilding +
                ", apartment=" + apartment +
                ", user=" + user +
                '}';
    }
}
