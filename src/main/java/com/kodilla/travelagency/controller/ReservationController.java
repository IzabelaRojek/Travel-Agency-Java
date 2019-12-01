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

    @GetMapping(value = "{reservationId}")
    public ReservationDto getReservationByNumber(@PathVariable Long reservationId) throws NotFoundException {
        return reservationMapper.mapToReservationDto(reservationService.getReservation(reservationId).orElseThrow(NotFoundException::new));
    }

    @PostMapping(value = "", consumes = APPLICATION_JSON_VALUE)
    public void addReservation(@RequestBody ReservationDto reservationDto) {
        reservationService.saveReservation(reservationMapper.mapToReservation(reservationDto));
    }
}
