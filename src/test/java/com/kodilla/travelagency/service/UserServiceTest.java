package com.kodilla.travelagency.service;

import com.kodilla.travelagency.domain.User;
import com.kodilla.travelagency.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;


    @Test
    public void shouldGetAllUsers() {
        //Given
        long numberOfUsersInDb = userRepository.count();
        System.out.println(numberOfUsersInDb);

        //When
        List<User> userList = userService.getAllUsers();
        System.out.println(userList.size());

        //Then
        assertEquals(numberOfUsersInDb, userList.size());
    }

    @Test
    public void shouldSaveUser() {
        //Given
        User user = new User(20L, "test", "lntest", "loginTest", "passwordTest", "user15@test");

        //When
        User savedUser = userService.saveUser(user);

        //Then
        List<User> userList = userService.getAllUsers();
        Optional<User> readUser = userRepository.findById(savedUser.getId());

        assertEquals(userRepository.count(), userList.size());
        assertTrue(readUser.isPresent());

        //CleanUp
        userRepository.deleteById(savedUser.getId());
    }

    @Test
    public void shouldGetUserById() {
        //Given
        User user = new User(20L, "test", "lntest", "loginTest", "passwordTest", "user15@test");
        User savedUser = userService.saveUser(user);

        //When
        Optional<User> readUser1 = userService.getUserById(savedUser.getId());

        //Then
        assertTrue(readUser1.isPresent());

        //CleanUp
        userRepository.deleteById(savedUser.getId());
    }

    @Test
    public void shouldGetUserByLogin() {
        //Given
        User user = new User(20L, "test", "lntest", "logsdghTest", "passwordTest", "user15@test");
        User savedUser = userService.saveUser(user);

        //When
        Optional<User> readUser = userService.getUser(savedUser.getLogin());


        //Then
        assertTrue(readUser.isPresent());

        //CleanUp
        userRepository.deleteById(savedUser.getId());
    }

    @Test
    public void shouldDeleteUser() {
        //Given
        User user = new User(20L, "test", "lntest", "log45Test", "passwordTest", "user15@test");
        User savedUser = userService.saveUser(user);

        //When
        userService.deleteUser(savedUser.getId());

        //Then
        Optional<User> readUser = userService.getUser(savedUser.getLogin());
        assertFalse(readUser.isPresent());
    }
}