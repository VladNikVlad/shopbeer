package com.gmail.vladyslavnicko.beerstore.services.comment;

import com.gmail.vladyslavnicko.beerstore.dto.CommentDTO;

public interface CommentServices {
    boolean addComment(CommentDTO commentDTO, long productId);
    void deleteComment(long commentId);
}
