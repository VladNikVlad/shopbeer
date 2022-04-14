package com.gmail.vladyslavnicko.beerstore.services.comment;

import com.gmail.vladyslavnicko.beerstore.dto.CommentDTO;
import com.gmail.vladyslavnicko.beerstore.model.Comment;
import com.gmail.vladyslavnicko.beerstore.model.Product;
import com.gmail.vladyslavnicko.beerstore.repository.CommentRepository;
import com.gmail.vladyslavnicko.beerstore.repository.ProductRepository;
import com.gmail.vladyslavnicko.beerstore.services.product.ProductService;
import org.springframework.stereotype.Service;

@Service
public class CommentServicesImpl implements CommentServices{

    private final CommentRepository commentRepository;
    private final ProductRepository productRepository;

    public CommentServicesImpl(CommentRepository commentRepository, ProductRepository productRepository) {
        this.commentRepository = commentRepository;
        this.productRepository = productRepository;
    }

    @Override
    public boolean addComment(CommentDTO commentDTO, long productId) {
        Comment comment = new Comment();
        comment.setComment(commentDTO.getComment());
        Product product = productRepository.findProductById(productId);
        product.addComment(comment);
        productRepository.save(product);
        return true;
    }

    @Override
    public void deleteComment(long commentId) {
        commentRepository.deleteById(commentId);
    }

}
