package com.kodilla.travelagency.service;

import com.kodilla.travelagency.domain.Trip;
import com.kodilla.travelagency.domain.TripType;
import com.kodilla.travelagency.domain.dto.TripDto;
import com.kodilla.travelagency.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

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

    public List<Trip> getTripsByType(TripType type) {
        return tripRepository.findByType(type);
    }

    public List<Trip> getTripsByDestination(String destination) {
        return tripRepository.findByDestination(destination);
    }

    public List<Trip> getTripsByStartDate(LocalDate date) {
        return tripRepository.findByStartDate(date);
    }

    public List<Trip> getTripsByStopDate(LocalDate date) {
        return tripRepository.findByStopDate(date);
    }

    public Trip saveTrip(final Trip trip) {
        return tripRepository.save(trip);
    }

    public Set<String> getAllAvailableDestinations() {
        List<Trip> trips = tripRepository.findAll();

        return trips.stream()
                .map(trip -> trip.getDestination())
                .collect(Collectors.toSet());
    }

    //public void deleteTrip();
}
