package com.gmail.vladyslavnicko.beerstore.services.categories;

import com.gmail.vladyslavnicko.beerstore.dto.CategoriesDTO;
import com.gmail.vladyslavnicko.beerstore.dto.UserDTO;
import com.gmail.vladyslavnicko.beerstore.model.Product;

import java.util.List;
import java.util.Set;

public interface CategoriesService {
    boolean addCategories(CategoriesDTO categoriesDTO);
    void deleteCategories(long categoriesId);
    List<Product> productByCategoriesRead(String title);
}
