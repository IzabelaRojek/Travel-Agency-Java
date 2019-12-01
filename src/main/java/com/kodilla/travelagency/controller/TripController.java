package com.kodilla.travelagency.controller;

import com.kodilla.travelagency.domain.dto.TripDto;
import com.kodilla.travelagency.exception.NotFoundException;
import com.kodilla.travelagency.mapper.TripMapper;
import com.kodilla.travelagency.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Transactional
@RequestMapping(value = "trip", produces = "application/json")
public class TripController {

    @Autowired
    private TripService tripService;

    @Autowired
    private TripMapper tripMapper;

    @GetMapping("getAll")
    public List<TripDto> getTrips() {
        return tripMapper.mapToTripDtoList(tripService.getAllTrips());
    }

    @GetMapping("{id}")
    public TripDto getTripById(@PathVariable Long id) throws NotFoundException {
        return tripMapper.mapToTripDto(tripService.getTripById(id).orElseThrow(NotFoundException::new));
    }

    @GetMapping("getTripByType")
    public TripDto getTripByType(@PathVariable String type) throws NotFoundException {
        return tripMapper.mapToTripDto(tripService.getTripByType(type).orElseThrow(NotFoundException::new));
    }

    @GetMapping("")
    public TripDto getTripByDestination(@PathVariable String destination) throws NotFoundException {
        return tripMapper.mapToTripDto(tripService.getTripByDestination(destination).orElseThrow(NotFoundException::new));
    }
}
