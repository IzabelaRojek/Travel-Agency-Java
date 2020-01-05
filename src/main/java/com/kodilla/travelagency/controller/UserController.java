package com.kodilla.travelagency.controller;

import com.kodilla.travelagency.domain.Log;
import com.kodilla.travelagency.domain.dto.UserDto;
import com.kodilla.travelagency.exception.NotFoundException;
import com.kodilla.travelagency.mapper.UserMapper;
import com.kodilla.travelagency.service.LogService;
import com.kodilla.travelagency.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "user", produces = "application/json")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private LogService logService;

    @PostMapping(value = "create", consumes = APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDto userDto) {
        userService.saveUser(userMapper.mapToUser(userDto));
    }

    @GetMapping("getAll")
    public List<UserDto> getUsers() {
        Log logOperation = new Log();
        logOperation.setOperation("User is displaying list of other users");
        logService.saveLog(logOperation);
        return userMapper.mapToUserDtoList(userService.getAllUsers());
    }

    @GetMapping("getUserByLogin/{login}")
    public UserDto getUserByLogin(@PathVariable String login) throws NotFoundException {
        return userMapper.mapToUserDto(userService.getUser(login).orElseThrow(NotFoundException::new));
    }

    @GetMapping("getUserByLastname/{lastname}")
    public List<UserDto> getUserByLastname(@PathVariable String lastname) throws NotFoundException {
        return userMapper.mapToUserDtoList(userService.getUserByLastname(lastname));
    }

    @GetMapping("getUser/{id}")
    public UserDto getUserById(@PathVariable Long id) throws NotFoundException {
        return userMapper.mapToUserDto(userService.getUserById(id).orElseThrow(NotFoundException::new));
    }

    @PutMapping(value = "update", consumes = APPLICATION_JSON_VALUE)
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return userMapper.mapToUserDto(userService.saveUser(userMapper.mapToUser(userDto)));
    }

    @DeleteMapping("{id}/delete")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
