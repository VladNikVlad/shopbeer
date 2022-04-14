package com.gmail.vladyslavnicko.beerstore.model;

import com.gmail.vladyslavnicko.beerstore.dto.ProductDTO;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private BigDecimal price;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "products_categories",
            joinColumns = @JoinColumn(name = "products_id"),
            inverseJoinColumns = @JoinColumn(name = "categories_id"))
    private List<Categories> categories = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<Comment> comments;

    public Product() {
    }

    public Product(String title, BigDecimal price) {
        this.title = title;
        this.price = price;
    }

    public void addCategories(Categories categori) {
        categories.add(categori);
        categori.addProduct(this);
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }
    public static Product of(String title, BigDecimal price){
        return new Product(title, price);
    }

    public static Product fromDTO(ProductDTO productDTO){
        return Product.of(productDTO.getTitle(), productDTO.getPrice());
    }

    public ProductDTO toDTO(){
        return ProductDTO.of(title, price);
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    //    public Set<Categories> getCategories() {
//        return categories;
//    }
//
//    public void setCategories(Set<Categories> categories) {
//        this.categories = categories;
//    }


    public List<Categories> getCategories() {
        return categories;
    }

    public void setCategories(List<Categories> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", categories=" + categories +
                '}';
    }
}
