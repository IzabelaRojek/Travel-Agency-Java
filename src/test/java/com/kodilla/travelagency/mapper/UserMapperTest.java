package com.kodilla.travelagency.mapper;

import com.kodilla.travelagency.domain.User;
import com.kodilla.travelagency.domain.dto.UserDto;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class UserMapperTest {
    private UserMapper userMapper = new UserMapper();

    @Test
    public void testMapToUserDto() {
        //Given
        User user = new User(15L, "fntest", "lntest", "loginTest", "passwordTest", "user15@test");

        //When
        UserDto userDto = userMapper.mapToUserDto(user);

        //Then
        assertEquals(user.getId(), userDto.getId());
        assertEquals(user.getFirstname(), userDto.getFirstname());
        assertEquals(user.getLastname(), userDto.getLastname());
        assertEquals(user.getLogin(), userDto.getLogin());
        assertEquals(user.getPassword(), userDto.getPassword());
        assertEquals(user.getEmail(), userDto.getEmail());
    }

    @Test
    public void testMapToUser() {
        //Given
        UserDto userDto = new UserDto(15L, "fntest", "lntest", "loginTest", "passwordTest", "user15@test");

        //When
        User user = userMapper.mapToUser(userDto);

        //Then
        assertEquals(userDto.getId(), user.getId());
        assertEquals(userDto.getFirstname(), user.getFirstname());
        assertEquals(userDto.getLastname(), user.getLastname());
        assertEquals(userDto.getLogin(), user.getLogin());
        assertEquals(userDto.getPassword(), user.getPassword());
        assertEquals(userDto.getEmail(), user.getEmail());
    }

    @Test
    public void testMapToUserDtoList() {
        //Given
        User user1 = new User(15L, "fn1test", "ln1test", "login1Test", "password1Test", "user1@test");
        User user2 = new User(19L, "fn2test", "ln2test", "login2Test", "password2Test", "user2@test");
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);

        //When
        List<UserDto> userDtoList = userMapper.mapToUserDtoList(users);

        //Then
        assertEquals(users.size(), userDtoList.size());
        UserDto userDto1 = userDtoList.get(0);
        UserDto userDto2 = userDtoList.get(1);
        assertEquals("fn1test", userDto1.getFirstname());
        assertEquals("login2Test", userDto2.getLogin());
    }
}
