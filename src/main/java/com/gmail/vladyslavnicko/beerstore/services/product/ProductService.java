package com.gmail.vladyslavnicko.beerstore.services.product;

import com.gmail.vladyslavnicko.beerstore.dto.ProductDTO;
import com.gmail.vladyslavnicko.beerstore.model.Categories;
import com.gmail.vladyslavnicko.beerstore.model.Comment;
import com.gmail.vladyslavnicko.beerstore.model.Product;

import java.util.List;

public interface ProductService {
    boolean addProduct(ProductDTO productDTO, String titleCategories);
    void deleteProduct(long userId);
    Iterable<Product> productAll();
    boolean UpdateProduct(ProductDTO productDTO, long productId, String titleCategories);
    List<Product> productRead(long id);
    Iterable<Product>  findProduct(String title);
    void addCategories(long productId, String titleCategories);
    List<Categories> ProductCategoriesAll(long productId);
    List<Comment> ProductCommentsAll(Long productId);
}
