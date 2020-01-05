package com.kodilla.travelagency.service;

import com.kodilla.travelagency.domain.User;
import com.kodilla.travelagency.exception.NotFoundException;
import com.kodilla.travelagency.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUser(final String login) {
        return userRepository.findByLogin(login);
    }

    public List<User> getUserByLastname(final String lastname) {
       /* List<User> users;
        try {
            users = userRepository.findByLastname(lastname);
        } catch (Exception e) {
            users = new ArrayList<>();
        }
        return users;*/

       return userRepository.findByLastname(lastname);
    }

    public Optional<User> getUserById(final Long id) {
        return userRepository.findById(id);
    }
    public User saveUser(final User user) {
        return userRepository.save(user);
    }

    public void deleteUser(final Long id) {
        userRepository.deleteById(id);
    }
}
