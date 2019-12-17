package com.kodilla.travelagency.controller;

import com.kodilla.travelagency.domain.dto.ReservationDto;
import com.kodilla.travelagency.exception.NotFoundException;
import com.kodilla.travelagency.mapper.ReservationMapper;
import com.kodilla.travelagency.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@Transactional
@RequestMapping(value = "reservation", produces = "application/json")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private ReservationMapper reservationMapper;


    @GetMapping(value = "getAll")
    public List<ReservationDto> getReservations() {
        return reservationMapper.mapToReservationDtoList(reservationService.getAllReservations());
    }

    @GetMapping(value = "{id}")
    public ReservationDto getReservationById(@PathVariable Long id) throws NotFoundException {
        return reservationMapper.mapToReservationDto(reservationService.getReservation(id).orElseThrow(NotFoundException::new));
    }

    @PostMapping(value = "", consumes = APPLICATION_JSON_VALUE)
    public void addReservation(@RequestBody ReservationDto reservationDto) {
        reservationService.saveReservation(reservationMapper.mapToReservation(reservationDto));
        reservationService.sendNewReservationEmail(reservationMapper.mapToReservation(reservationDto));
    }

    @PutMapping(value = "", consumes = APPLICATION_JSON_VALUE)
    public ReservationDto updateReservation(@RequestBody ReservationDto reservationDto) {
        return reservationMapper.mapToReservationDto(reservationService.saveReservation(reservationMapper.mapToReservation(reservationDto)));
    }

    @DeleteMapping("{id}/delete")
    public void deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
    }
}
