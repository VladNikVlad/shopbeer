package com.gmail.vladyslavnicko.beerstore.repository;

import com.gmail.vladyslavnicko.beerstore.model.Userr;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <Userr, Long> {
    Optional<Userr> findByEmail(String email);
}
