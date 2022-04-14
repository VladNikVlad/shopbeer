package com.gmail.vladyslavnicko.beerstore.services.product;

import com.gmail.vladyslavnicko.beerstore.dto.ProductDTO;
import com.gmail.vladyslavnicko.beerstore.model.Categories;
import com.gmail.vladyslavnicko.beerstore.model.Comment;
import com.gmail.vladyslavnicko.beerstore.model.Product;
import com.gmail.vladyslavnicko.beerstore.repository.CategoriesRepository;
import com.gmail.vladyslavnicko.beerstore.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class productServicesImpl implements ProductService{

    private final ProductRepository productRepository;
    private final CategoriesRepository categoriesRepository;

    public productServicesImpl(ProductRepository productRepository, CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
        this.productRepository = productRepository;
    }

    @Override
    public boolean addProduct(ProductDTO productDTO, String titleCategories) {
        if(productDTO.getTitle() == null) {
            throw new RuntimeException("Title is null");
        }
        Categories categories = categoriesRepository.findCategoriesByTitle(titleCategories);
        Product product = new Product();
        product.setTitle(productDTO.getTitle());
        product.setPrice(productDTO.getPrice());
        if (categories == null) {
            return false;
        }
        product.addCategories(categories);
        productRepository.save(product);
        return true;
    }

    @Override
    public void deleteProduct(long productId) {
        if(!productRepository.existsById(productId)){
            return;
        }
        productRepository.deleteById(productId);
    }

    @Override
    public Iterable<Product> productAll() {
        Iterable<Product> products = productRepository.findAll();
        return products;
    }

    @Override
    public boolean UpdateProduct(ProductDTO productDTO, long id, String titleCategories) {
        Categories categories;
        if(!productRepository.existsById(id)){
            return false;
        }

        Product product = Product.fromDTO(productDTO);
        product.setId(id);

        if((categories = categoriesRepository.findCategoriesByTitle(titleCategories)) != null){
            product.addCategories(categories);;
        }

        productRepository.save(product);
        return true;
    }

    @Override
    public List<Product> productRead(long id){
        Optional<Product> product = productRepository.findById(id);
        List<Product> list = new ArrayList<>();
        product.ifPresent(list::add);
        return list;
    }

    @Override
    public Iterable<Product> findProduct(String title){
        Iterable<Product> products = productRepository.findProductByTitle(title);
        return products;
    }

    @Override
    public void addCategories(long productId, String titleCategories){
        if(!productRepository.existsById(productId)){
            return;
        }
        Product product = productRepository.findProductById(productId);
        Categories categories = categoriesRepository.findCategoriesByTitle(titleCategories);
        product.addCategories(categories);
        productRepository.save(product);
    }

    @Override
    public List<Categories> ProductCategoriesAll(long productId){
        List<Categories> categories;
        Product product = productRepository.findProductById(productId);
        categories = product.getCategories();
        return categories;
    }

    @Override
    public List<Comment> ProductCommentsAll(Long productId){
        List<Comment> comments;
        Product product = productRepository.findProductById(productId);
        comments = product.getComments();
        return comments;
    }


}
