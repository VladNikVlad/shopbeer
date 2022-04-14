package com.gmail.vladyslavnicko.beerstore.services.categories;

import com.gmail.vladyslavnicko.beerstore.dto.CategoriesDTO;
import com.gmail.vladyslavnicko.beerstore.model.Categories;
import com.gmail.vladyslavnicko.beerstore.model.Product;
import com.gmail.vladyslavnicko.beerstore.repository.CategoriesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CategoriesServiceImpl implements CategoriesService{

    private final CategoriesRepository categoriesRepository;

    public CategoriesServiceImpl(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }


    @Override
    public boolean addCategories(CategoriesDTO categoriesDTO) {
        if(categoriesDTO.getTitle() == null) {
            throw new RuntimeException("Title is null");
        }

        Categories categories = new Categories();
        categories.setTitle(categoriesDTO.getTitle());
        categoriesRepository.save(categories);
        return true;
    }

    @Override
    public void deleteCategories(long categoriesId) {
        categoriesRepository.deleteById(categoriesId);
    }

    @Override
    public List<Product> productByCategoriesRead(String title) {
        Categories categories = categoriesRepository.findCategoriesByTitle(title);
        List<Product> products = categories.getProducts();
        return products;
    }
}
