package com.kodilla.travelagency.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private Long id;

    @Column
    private String firstname;

    @Column
    private String lastname;

    @Column//(unique = true)
    @NotNull
    private String login;

    @Column
    @NotNull
    private String password;

    @Column
    private String email;

    @OneToMany(
            targetEntity = Reservation.class,
            mappedBy = "user",
            cascade = CascadeType.MERGE,
            fetch = FetchType.LAZY
    )
    private List<Reservation> reservations;

    public User(Long id, String firstname, String lastname, @NotNull String login, @NotNull String password, String email) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.login = login;
        this.password = password;
        this.email = email;
    }
}
