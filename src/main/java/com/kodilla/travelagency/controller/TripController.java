package com.kodilla.travelagency.controller;

import com.kodilla.travelagency.domain.TripType;
import com.kodilla.travelagency.domain.dto.TripDto;
import com.kodilla.travelagency.exception.NotFoundException;
import com.kodilla.travelagency.mapper.TripMapper;
import com.kodilla.travelagency.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

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

    @GetMapping("getByType/{type}")
    public List<TripDto> getTripByType(@PathVariable TripType type) {
        return tripMapper.mapToTripDtoList(tripService.getTripsByType(type));
    }

    @GetMapping("getByStartDate/{date}")
    public List<TripDto> getTripsByStartDate(@PathVariable LocalDate date) {
        return tripMapper.mapToTripDtoList(tripService.getTripsByStartDate(date));
    }

    @GetMapping("getByStopDate/{date}")
    public List<TripDto> getTripsByStopDate(@PathVariable LocalDate date) {
        return tripMapper.mapToTripDtoList(tripService.getTripsByStopDate(date));
    }

    @GetMapping("getByDest/{destination}")
    public List<TripDto> getTripsByDestination(@PathVariable String destination) {
        return tripMapper.mapToTripDtoList(tripService.getTripsByDestination(destination));
    }

    @PostMapping(value = "create", consumes = APPLICATION_JSON_VALUE)
    public void createTrip(@RequestBody TripDto tripDto) {
        tripService.saveTrip(tripMapper.mapToTrip(tripDto));
        tripService.sendNewTripEmail(tripMapper.mapToTrip(tripDto));
    }

    @GetMapping("getDestinations")
    public Set<String> getAllDestinations() {
        return tripService.getAllAvailableDestinations();
    }

    @PutMapping("update")
    public TripDto updateTrip(@RequestBody TripDto tripDto) {
        return tripMapper.mapToTripDto(tripService.saveTrip(tripMapper.mapToTrip(tripDto)));
    }
}
