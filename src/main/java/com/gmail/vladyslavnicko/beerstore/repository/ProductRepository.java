package com.gmail.vladyslavnicko.beerstore.repository;

import com.gmail.vladyslavnicko.beerstore.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product>  findProductByTitle(String title);
    Product findProductById(long id);
}
