package com.kodilla.travelagency.domain.dto;

import com.kodilla.travelagency.domain.Reservation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;
    private String firstname;
    private String lastname;
    private String login;
    private String password;
    private String email;
    private List<Reservation> reservations;

    public UserDto(Long id, String firstname, String lastname, String login, String password, String email) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.login = login;
        this.password = password;
        this.email = email;
    }
}
