package com.gmail.vladyslavnicko.beerstore.repository;

import com.gmail.vladyslavnicko.beerstore.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
