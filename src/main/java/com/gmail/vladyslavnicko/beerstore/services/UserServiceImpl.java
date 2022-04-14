package com.gmail.vladyslavnicko.beerstore.services;

import com.gmail.vladyslavnicko.beerstore.dto.UserDTO;
import com.gmail.vladyslavnicko.beerstore.model.Role;
import com.gmail.vladyslavnicko.beerstore.model.Status;
import com.gmail.vladyslavnicko.beerstore.model.User;
import com.gmail.vladyslavnicko.beerstore.repository.User2Repository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService{
    private final User2Repository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(User2Repository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean addUser(UserDTO userDto) {
        if(!Objects.equals(userDto.getPassword(), userDto.getMatchingPassword())) {
            throw new RuntimeException("password is not equals");
        }

        User user = new User();
        user.setName(userDto.getName());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRole(Role.USER);
        user.setStatus(Status.BANNED);
        userRepository.save(user);

        return true;
    }

    @Override
    public void deleteUser(long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public UserDetails loadUserByEserLogin(String login) {
        User user = userRepository.findByLogin(login);
        if (user == null) {
            throw new UsernameNotFoundException("user not found with login" + login);
        }

        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(user.getRole().name()));

        return new org.springframework.security.core.userdetails.User(
                user.getName(),
                user.getPassword(),
                roles
        );
    }
}
