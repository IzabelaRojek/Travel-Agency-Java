package com.kodilla.travelagency.service;

import com.kodilla.travelagency.domain.Trip;
import com.kodilla.travelagency.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripService {

    @Autowired
    private TripRepository tripRepository;

    public List<Trip> getAllTrips(){
        return tripRepository.findAll();
    }

    public Optional<Trip> getTripById(final Long id){
        return tripRepository.findById(id);
    }

    public Optional<Trip> getTripByType(String type) {
        return tripRepository.findByType(type);
    }

    public Optional<Trip> getTripByDestination(String destination) {
        return tripRepository.findByDestination(destination);
    }
}
