package com.gmail.vladyslavnicko.beerstore.controllers;

import com.gmail.vladyslavnicko.beerstore.dto.CategoriesDTO;
import com.gmail.vladyslavnicko.beerstore.model.Product;
import com.gmail.vladyslavnicko.beerstore.services.categories.CategoriesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/categories")
public class CategoriesController {

    private final CategoriesService categoriesService;

    public CategoriesController(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    @GetMapping
    public String categories(Model mode){
        return "categories";
    }

    //add categories
    @GetMapping("/add")
    public String addCategories(Model model){
        return "categories-add";
    }

    @PostMapping("/add")
    public String saveCategories(@RequestParam String title, Model model){
        CategoriesDTO categoriesDTO = new CategoriesDTO(title);
        categoriesService.addCategories(categoriesDTO);
        return "redirect:/categories";
    }

    //find categories
    @GetMapping("/find/{title}")
    public String categoriesFindProduct(@PathVariable(value = "title") String title, Model model){
        List<Product> list = categoriesService.productByCategoriesRead(title);
        model.addAttribute("categories", list);
        return "categories_find";
    }
}
