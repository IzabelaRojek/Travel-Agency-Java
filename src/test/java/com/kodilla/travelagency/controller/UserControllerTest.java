package com.kodilla.travelagency.controller;

import com.kodilla.travelagency.domain.User;
import com.kodilla.travelagency.domain.dto.UserDto;
import com.kodilla.travelagency.mapper.UserMapper;
import com.kodilla.travelagency.service.LogService;
import com.kodilla.travelagency.service.UserService;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserMapper userMapper;

    @MockBean
    UserService userService;

    @MockBean
    LogService logService;

    @Test
    public void shouldGetEmptyListOfUsers() throws Exception {
        //Given
        List<UserDto> userDtoList = new ArrayList<>();
        List<User> users = new ArrayList<>();
        when(userMapper.mapToUserDtoList(users)).thenReturn(userDtoList);
        when(userService.getAllUsers()).thenReturn(users);

        //When & Then
        mockMvc.perform(get("/user/getAll").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void shouldGetUsers() throws Exception {
        //Given
        List<UserDto> userDtoList = new ArrayList<>();
        userDtoList.add(new UserDto(1L, "fn1test", "ln1test", "login1Test", "password1Test", "user1@test"));
        userDtoList.add(new UserDto(2L, "fn2test", "ln2test", "login2Test", "password2Test", "user2@test"));

        List<User> users = new ArrayList<>();
        users.add(new User(1L, "fn1test", "ln1test", "login1Test", "password1Test", "user1@test"));
        users.add(new User(2L, "fn2test", "ln2test", "login2Test", "password2Test", "user2@test"));

        when(userMapper.mapToUserDtoList(users)).thenReturn(userDtoList);
        when(userService.getAllUsers()).thenReturn(users);

        //When
        mockMvc.perform(get("/user/getAll").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(2)));

    }

    @Test
    public void shouldGetUserById() throws Exception {
        //Given
        User user = new User(1L, "firstname", "lastname", "login", "password", "email");
        UserDto userDto = new UserDto(1L, "firtname", "lastname", "login", "password", "email");

        when(userService.getUserById(1L)).thenReturn(Optional.of(user));
        when(userMapper.mapToUserDto(user)).thenReturn(userDto);

        //When & Then
        mockMvc.perform(get("/user/getUser/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.id", is(1)));

    }

    @Test
    public void shouldCreateUser() throws Exception {
        //Given
        User user = new User(1L, "firstname", "lastname", "login", "password", "email");
        UserDto userDto = new UserDto(1L, "firstname", "lastname", "login", "password", "email");

        when(userService.saveUser(user)).thenReturn(user);
        when(userMapper.mapToUserDto(user)).thenReturn(userDto);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(userDto);

        //When & Then
        mockMvc.perform(post("/user/create").contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                    .andExpect(status().isOk());
    }

    @Test
    public void shouldGetUserByLogin() throws Exception {
        //Given
        User user = new User(1L, "firstname", "lastname", "login", "password", "email");
        UserDto userDto = new UserDto(1L, "firtname", "lastname", "login", "password", "email");

        when(userService.getUser("login")).thenReturn(Optional.of(user));
        when(userMapper.mapToUserDto(user)).thenReturn(userDto);

        //When & Then
        mockMvc.perform(get("/user/getUserByLogin/login").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.login", is("login")));
    }

    @Test
    public void shouldUpdateUser() throws Exception {
        //Given
        User user = new User(1L, "firstname", "lastname", "login", "password", "email");
        UserDto userDto = new UserDto(1L, "firtname", "lastname", "login", "password", "email");

        when(userMapper.mapToUser(userDto)).thenReturn(user);
        when(userService.saveUser(user)).thenReturn(user);
        when(userMapper.mapToUserDto(user)).thenReturn(userDto);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(userDto);

        //When & Then
        mockMvc.perform(put("/user/update").contentType(MediaType.APPLICATION_JSON)
            .characterEncoding("UTF-8")
            .content(jsonContent))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldDeleteUser() throws Exception {
        //Given
        User user = new User(1L, "firstname", "lastname", "login", "password", "email");
        userService.saveUser(user);

        //When & Then
        mockMvc.perform(delete("/user/1/delete"))
                .andExpect(status().isOk());

    }
}