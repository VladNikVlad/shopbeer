package com.gmail.vladyslavnicko.beerstore.model;

import com.gmail.vladyslavnicko.beerstore.dto.CommentDTO;

import javax.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue
    private Long id;

    private String comment;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Product getProduct() {
        return product;
    }

    public Comment() {
    }

    public Comment(String comment) {
        this.comment = comment;
    }

    public static Comment of(String comment){
        return new Comment(comment);
    }

    public CommentDTO toDto(){
        return CommentDTO.of(comment);
    }

    public static Comment fromDTO(CommentDTO commentDTO){
        return Comment.of(commentDTO.getComment());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                '}';
    }
}
