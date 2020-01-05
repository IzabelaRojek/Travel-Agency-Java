package com.kodilla.travelagency.mapper;

import com.kodilla.travelagency.domain.Reservation;
import com.kodilla.travelagency.domain.dto.ReservationDto;
import com.kodilla.travelagency.domain.dto.ReservationDtoForView;
import com.kodilla.travelagency.service.TripService;
import com.kodilla.travelagency.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReservationMapper {

    @Autowired
    private UserService userService;

    @Autowired
    private TripService tripService;

    public List<ReservationDto> mapToReservationDtoList(final List<Reservation> reservations) {
        return reservations.stream()
                .map(r -> new ReservationDto(r.getId(), r.getUser().getId(), r.getTrip().getId(), r.isConfirmed()))
                //.map(r -> mapToReservationDto(r))
                .collect(Collectors.toList());
    }

    public ReservationDto mapToReservationDto(final Reservation reservation) {
        return new ReservationDto(reservation.getId(), reservation.getUser().getId(),
                reservation.getTrip().getId(), reservation.isConfirmed());
    }

    public Reservation mapToReservation(final ReservationDto reservationDto) {
       return new Reservation(
                reservationDto.getId(), userService.getUserById(reservationDto.getUserId()).orElse(null),
               tripService.getTripById(reservationDto.getTripId()).orElse(null), reservationDto.isConfirmed());
    }

    public List<ReservationDtoForView> mapToReservationDtoForViewList(final List<Reservation> reservations) {
        return reservations.stream()
                .map(r -> new ReservationDtoForView(r.getId(), r.getUser().getFirstname(), r.getUser().getLastname(),
                        r.getUser().getLogin(), r.getTrip().getName(), r.getTrip().getDestination(),
                        r.getTrip().getStartDate(), r.getTrip().getStopDate(), r.getTrip().getType(),
                        r.getTrip().getPrice(), r.isConfirmed()))
                .collect(Collectors.toList());
    }
}
