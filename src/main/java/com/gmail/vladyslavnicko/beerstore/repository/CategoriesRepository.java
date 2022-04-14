package com.gmail.vladyslavnicko.beerstore.repository;

import com.gmail.vladyslavnicko.beerstore.model.Categories;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Long> {
    List<Categories> findByTitle (String title, Pageable pageable);
    Categories findCategoriesByTitle(String title);
}
