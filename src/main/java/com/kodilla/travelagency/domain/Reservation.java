package com.kodilla.travelagency.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "RESERVATIONS")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private Long id;

    @ManyToOne//(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne//(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "TRIP_ID")
    private Trip trip;

    @Column(name = "CONFIRMED")
    private boolean isConfirmed;

    @Override
    public String toString() {
        return '\n' + "Reservation for: " + user.getFirstname() + " " + user.getLastname() + ", email: " + user.getEmail() +
                + '\n' + ", trip: " + trip.getName() + " start: " +  trip.getStartDate();
    }
}
