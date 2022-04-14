package com.gmail.vladyslavnicko.beerstore.controllers;

import com.gmail.vladyslavnicko.beerstore.dto.UserDTO;
import com.gmail.vladyslavnicko.beerstore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/new")
    public String newUser(Model model){
        model.addAttribute("user", new UserDTO());
        return "user";
    }

    @PostMapping("/new")
    public String saveUser(@RequestParam String name, @RequestParam String password, @RequestParam String matchingPassword,
                           @RequestParam String email, Model model){
        UserDTO userDto = new UserDTO(name, password, matchingPassword, email);
        if(userService.addUser(userDto)){
            return "redirect:/";
        }
        else {
            model.addAttribute("user", userDto);
            return "user";
        }
    }
}
