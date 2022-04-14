package com.gmail.vladyslavnicko.beerstore.dto;

import lombok.Data;

@Data
public class CommentDTO {
    private Long id;

    private String comment;

    public CommentDTO() {
    }

    public CommentDTO(String comment) {
        this.comment = comment;
    }

    public static CommentDTO of (String comment){
        return new CommentDTO(comment);
    }
}
