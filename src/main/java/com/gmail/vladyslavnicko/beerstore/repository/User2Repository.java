package com.gmail.vladyslavnicko.beerstore.repository;

import com.gmail.vladyslavnicko.beerstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface User2Repository extends JpaRepository<User, Long> {
    User findByLogin(String login);
    boolean existsByEmail(String login);
    User findByEmail(String email);
}
