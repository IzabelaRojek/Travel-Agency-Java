package com.kodilla.travelagency.service;

import com.kodilla.travelagency.domain.Reservation;
import com.kodilla.travelagency.domain.Trip;
import com.kodilla.travelagency.domain.TripType;
import com.kodilla.travelagency.domain.User;
import com.kodilla.travelagency.repository.ReservationRepository;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ReservationServiceTest {
    @Autowired
    ReservationService reservationService;

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    UserService userService;

    @Autowired
    TripService tripService;

    @Test
    public void shouldGetAllReservations() {
        //Given
        long numberOfReservationsInDb = reservationRepository.count();

        //When
        List<Reservation> reservations = reservationService.getAllReservations();

        //Then
        assertEquals(numberOfReservationsInDb, reservations.size());
    }

    @Test
    public void shouldSaveReservation() {
        //Given
        User user = new User(60L, "fn60test", "ln60test", "login60Test", "password60Test", "user60@test");
        Trip trip = new Trip(61L, "trip61name", "destination61", "desc61", LocalDate.of(2019, 12, 11), LocalDate.of(2019, 12, 18), TripType.PLANE, new BigDecimal(3500));
        User savedUser = userService.saveUser(user);
        Trip savedTrip = tripService.saveTrip(trip);
        Reservation reservation = new Reservation(19L, savedUser, savedTrip, false);

        //When
        Reservation savedReservation = reservationService.saveReservation(reservation);

        //Then
        List<Reservation> reservations = reservationService.getAllReservations();
        Optional<Reservation> readReservation = reservationRepository.findById(savedReservation.getId());

        assertTrue(readReservation.isPresent());

        //CleanUp
        reservationRepository.deleteById(savedReservation.getId());
        userService.deleteUser(savedUser.getId());
        tripService.deleteTrip(savedTrip.getId());
    }

    @Test
    public void shouldGetReservationById() {
        //Given
        User user = new User(60L, "fn60test", "ln60test", "login60Test", "password60Test", "user60@test");
        Trip trip = new Trip(61L, "trip61name", "destination61", "desc61", LocalDate.of(2019, 12, 11), LocalDate.of(2019, 12, 18), TripType.PLANE, new BigDecimal(3500));
        User savedUser = userService.saveUser(user);
        Trip savedTrip = tripService.saveTrip(trip);
        Reservation reservation = new Reservation(19L, savedUser, savedTrip, false);
        Reservation savedReservation = reservationService.saveReservation(reservation);

        //When
        Optional<Reservation> readReservation = reservationService.getReservation(savedReservation.getId());

        //Then
        assertTrue(readReservation.isPresent());

        //CleanUp
        reservationRepository.deleteById(savedReservation.getId());
        userService.deleteUser(savedUser.getId());
        tripService.deleteTrip(savedTrip.getId());
    }

    @Test
    public void shouldDeleteReservation() {
        //Given
        User user = new User(60L, "fn60test", "ln60test", "login60Test", "password60Test", "user60@test");
        Trip trip = new Trip(61L, "trip61name", "destination61", "desc61", LocalDate.of(2019, 12, 11), LocalDate.of(2019, 12, 18), TripType.PLANE, new BigDecimal(3500));
        User savedUser = userService.saveUser(user);
        Trip savedTrip = tripService.saveTrip(trip);
        Reservation reservation = new Reservation(19L, savedUser, savedTrip, false);
        Reservation savedReservation = reservationService.saveReservation(reservation);

        //When
        reservationService.deleteReservation(savedReservation.getId());

        //Then
        Optional<Reservation> readReservation = reservationService.getReservation(savedReservation.getId());
        assertFalse(readReservation.isPresent());

        //CleanUp
        userService.deleteUser(savedUser.getId());
        tripService.deleteTrip(savedTrip.getId());
    }
}