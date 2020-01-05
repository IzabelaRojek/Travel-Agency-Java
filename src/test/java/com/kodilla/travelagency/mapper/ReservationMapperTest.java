package com.kodilla.travelagency.mapper;

import com.kodilla.travelagency.domain.Reservation;
import com.kodilla.travelagency.domain.Trip;
import com.kodilla.travelagency.domain.TripType;
import com.kodilla.travelagency.domain.User;
import com.kodilla.travelagency.domain.dto.ReservationDto;
import com.kodilla.travelagency.repository.ReservationRepository;
import com.kodilla.travelagency.repository.TripRepository;
import com.kodilla.travelagency.repository.UserRepository;
import com.kodilla.travelagency.service.ReservationService;
import com.kodilla.travelagency.service.TripService;
import com.kodilla.travelagency.service.UserService;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@SpringBootTest
//@RunWith(SpringRunner.class)
public class ReservationMapperTest {

    //@Autowired
    private ReservationMapper reservationMapper;
   // @Autowired
    private UserService userService;
   // @Autowired
    private TripService tripService;
   // @Autowired
    private ReservationService reservationService;

    @Autowired
    UserRepository userRepository;
    @Autowired
    TripRepository tripRepository;
    @Autowired
    ReservationRepository reservationRepository;

//    @Ignore
//    @Test
//    void mapToReservationDtoList() {
//        //Given
//        Reservation reservation1 = new Reservation(
//                1L,
//                new User(15L, "fn1test", "ln1test", "login1Test", "password1Test", "user1@test"),
//                new Trip(1L, "trip1name", "destination1", "desc1", LocalDate.of(2019, 12, 11), LocalDate.of(2019, 12, 18), TripType.PLANE, new BigDecimal(3500)),
//                true
//        );
//        Reservation reservation2 = new Reservation(
//                2L,
//                new User(19L, "fn2test", "ln2test", "login2Test", "password2Test", "user2@test"),
//                new Trip(2L, "trip1name", "destination1", "desc1", LocalDate.of(2019, 12, 11), LocalDate.of(2019, 12, 25), TripType.PLANE, new BigDecimal(4500)),
//                false
//        );
//        List<Reservation> reservations = new ArrayList<>();
//        reservations.add(reservation1);
//        reservations.add(reservation2);
//
//        //When
//        List<ReservationDto> reservationDtoList = reservationMapper.mapToReservationDtoList(reservations);
//
//        //Then
//        assertEquals(2, reservationDtoList.size());
//        assertEquals(reservation1.getId(), reservationDtoList.get(0).getId());
//        assertEquals(reservations.get(0).getUser().getId(), reservationDtoList.get(0).getUserId());
//    }

//    @Ignore
//    @Test
//    void mapToReservation() {
//        //Given
//        User user = new User(17L, "fn1test", "ln1test", "login1Test", "password1Test", "user1@test");
//        Trip trip = new Trip(18L, "trip1name", "destination1", "desc1", LocalDate.of(2019, 12, 11), LocalDate.of(2019, 12, 18), TripType.PLANE, new BigDecimal(3500));
//        User savedUser = userRepository.save(user); //userService.saveUser(user);
//        Trip savedTrip = tripRepository.save(trip); //tripService.saveTrip(trip);
//        Reservation reservation = new Reservation(1L, savedUser, savedTrip, false);
//        Reservation savedReservation = reservationRepository.save(reservation); //reservationService.saveReservation(reservation);
//
//        ReservationDto reservationDto = new ReservationDto(reservation.getId(), reservation.getUser().getId(), reservation.getTrip().getId(),reservation.isConfirmed());
//
//        //When
//        Reservation mappedReservation = reservationMapper.mapToReservation(reservationDto);
//
//        //Then
//        assertEquals(savedReservation.getId(), mappedReservation.getId());
//        assertEquals(savedReservation.getUser().getId(), mappedReservation.getUser().getId());
//        assertEquals(savedReservation.getTrip().getDescription(), mappedReservation.getTrip().getDescription());
//
//        //CleanUp
//        reservationRepository.deleteById(savedReservation.getId());
//        tripRepository.deleteById(savedTrip.getId());
//        userRepository.deleteById(savedUser.getId());
//    }
}