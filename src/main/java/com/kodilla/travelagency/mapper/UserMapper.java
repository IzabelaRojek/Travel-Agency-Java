package com.kodilla.travelagency.mapper;

import com.kodilla.travelagency.domain.User;
import com.kodilla.travelagency.domain.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public List<UserDto> mapToUserDtoList(final List<User> users) {
        return users.stream()
                //.map(u -> new UserDto(u.getId(), u.getFirstname(), u.getLastname(), u.getLogin(), u.getPassword(), u.getEmail()))
                .map(u -> mapToUserDto(u))
                .collect(Collectors.toList());
    }

    public UserDto mapToUserDto(final User user) {
        return new UserDto(user.getId(), user.getFirstname(), user.getLastname(), user.getLogin(), user.getPassword(), user.getEmail());
    }

    public User mapToUser(final UserDto userDto) {
        return new User(userDto.getId(), userDto.getFirstname(), userDto.getLastname(), userDto.getLogin(), userDto.getPassword(), userDto.getEmail());
    }
}
