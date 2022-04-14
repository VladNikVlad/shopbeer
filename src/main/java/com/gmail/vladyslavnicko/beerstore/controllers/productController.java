package com.gmail.vladyslavnicko.beerstore.controllers;


import com.gmail.vladyslavnicko.beerstore.dto.CategoriesDTO;
import com.gmail.vladyslavnicko.beerstore.dto.ProductDTO;
import com.gmail.vladyslavnicko.beerstore.model.Categories;
import com.gmail.vladyslavnicko.beerstore.model.Comment;
import com.gmail.vladyslavnicko.beerstore.model.Product;
import com.gmail.vladyslavnicko.beerstore.services.product.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/product")
public class productController {
    private final ProductService productService;

    public productController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String product(Model model){
        Iterable<Product> products = productService.productAll();
        model.addAttribute("products", products);
        return "product";
    }

    @GetMapping("/add")
    public String addProduct(Model model){
        return "product_add";
    }

    @GetMapping("/{id}/edit")
    public String productEdit(@PathVariable(value = "id") long id,  Model model){
        List<Product> list = productService.productRead(id);
        model.addAttribute("product", list);

//        model.addAttribute("categories", )
        return "product_edit";
    }

    @PostMapping("/add")
    public String saveProduct(@RequestParam String title, @RequestParam BigDecimal price,
                              @RequestParam String titleCategories){
        ProductDTO productDTO = new ProductDTO(title, price);
        //CategoriesDTO categoriesDTO = new CategoriesDTO(titleCategories);
        productService.addProduct(productDTO, titleCategories);
        return "redirect:/product";
    }

    @PostMapping("/{id}/remove")
    public String productDelete(@PathVariable(value = "id") long id){
        productService.deleteProduct(id);
        return "redirect:/product";
    }

    @PostMapping("/{id}/edit")
    public String roductUpdate(@PathVariable(value = "id") long id, @RequestParam String title,
                               @RequestParam BigDecimal price, @RequestParam String titleCategories){
        ProductDTO productDTO = new ProductDTO(title, price);
        productService.UpdateProduct(productDTO, id, titleCategories);


        return "redirect:/product";
    }

    @GetMapping("/find/{title}")
    public String productFind(@PathVariable(value = "title") String title, Model model){
        Iterable<Product>  list = productService.findProduct(title);
        model.addAttribute("products", list);
        return "product_find";
    }

    @GetMapping("/{id}/more")
    public String productMore(@PathVariable(value = "id") long id,  Model model){
        List<Product> products = productService.productRead(id);
        List<Categories> categoriesSet = productService.ProductCategoriesAll(id);
        List<Comment> comments = productService.ProductCommentsAll(id);
        model.addAttribute("ctegories", categoriesSet);
        model.addAttribute("products", products);
        model.addAttribute("comments", comments);
        return "product_more";
    }
}
