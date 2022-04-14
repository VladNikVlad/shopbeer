package com.gmail.vladyslavnicko.beerstore.services;

import com.gmail.vladyslavnicko.beerstore.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {
    boolean addUser(UserDTO  userDto);
    void deleteUser(long userId);
    // void findByLogin(String login);

    UserDetails loadUserByEserLogin(String login);
}
