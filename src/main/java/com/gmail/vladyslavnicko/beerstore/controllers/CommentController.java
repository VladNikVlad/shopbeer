package com.gmail.vladyslavnicko.beerstore.controllers;

import com.gmail.vladyslavnicko.beerstore.dto.CommentDTO;
import com.gmail.vladyslavnicko.beerstore.services.comment.CommentServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/comment")
public class CommentController {

    private final CommentServices commentServices;

    public CommentController(CommentServices commentServices) {
        this.commentServices = commentServices;
    }

    @GetMapping
    public String comment(Model model){
        return  "comment";
    }

    @GetMapping("/add")
    public String AddComment(){
        return "comment_add";
    }

    @PostMapping("/{id}/add")
    public String saveComment(@PathVariable(value = "id") long id, @RequestParam String comment, Model model){
        CommentDTO commentDTO = new CommentDTO(comment);
        commentServices.addComment(commentDTO, id);
        return "redirect:/product/{id}/more";
    }
}
