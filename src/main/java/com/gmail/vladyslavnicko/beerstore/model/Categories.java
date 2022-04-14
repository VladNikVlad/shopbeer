package com.gmail.vladyslavnicko.beerstore.model;

import com.gmail.vladyslavnicko.beerstore.dto.CategoriesDTO;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Categories {
    @Id
    @GeneratedValue
    private Long id;
    private String title;

    @ManyToMany(mappedBy = "categories")
//    @JoinTable(name = "categories_categories",
//            joinColumns = @JoinColumn(name = "categories_id", referencedColumnName = "categories_id"))
    private List<Product> products = new ArrayList<>();
//
//    public Set<Product> getProducts() {
//        return products;
//    }
//
//    public void setProducts(Set<Product> products) {
//        this.products = products;
//    }


    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Categories() {
    }

    public Categories(String title) {

        this.title = title;
    }

    public static Categories of(String title){
        return new Categories(title);
    }

    public static Categories fromDTO(CategoriesDTO categoriesDTO){
        return Categories.of(categoriesDTO.getTitle());
    }

    public CategoriesDTO toDTO(){
        return CategoriesDTO.of(title);
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Categories{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
