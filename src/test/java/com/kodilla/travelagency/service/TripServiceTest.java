package com.kodilla.travelagency.service;

import com.kodilla.travelagency.domain.Trip;
import com.kodilla.travelagency.domain.TripType;
import com.kodilla.travelagency.repository.TripRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TripServiceTest {
    @Autowired
    TripService tripService;

    @Autowired
    TripRepository tripRepository;

    @Test
    public void shouldGetAllTrips() {
        //Given
        long numberOfTripsInDb = tripRepository.count();

        ///When
        List<Trip> trips = tripService.getAllTrips();

        //Then
        assertEquals(numberOfTripsInDb, trips.size());
    }

    @Test
    public void shouldSaveTrip() {
        //Given
        Trip trip1 = new Trip(1L, "trip1name", "destination1", "desc1", LocalDate.of(2019, 12, 11), LocalDate.of(2019, 12, 18), TripType.PLANE, new BigDecimal(3500));

        //When
        Trip savedTrip = tripService.saveTrip(trip1);
        Optional<Trip> readTrip = tripRepository.findById(savedTrip.getId());

        //Then
        List<Trip> trips = tripService.getAllTrips();
        assertEquals(tripRepository.count(), trips.size());
        assertTrue(readTrip.isPresent());

        //CleanUp
        tripRepository.deleteById(savedTrip.getId());
    }

    @Test
    public void shouldGetTripById() {
        //Given
        Trip trip1 = new Trip(1L, "trip1name", "destination1", "desc1", LocalDate.of(2019, 12, 11), LocalDate.of(2019, 12, 18), TripType.PLANE, new BigDecimal(3500));
        Trip savedTrip = tripService.saveTrip(trip1);

        //When
        Optional<Trip> readTrip = tripService.getTripById(savedTrip.getId());

        //Then
        assertTrue(readTrip.isPresent());

        //CleanUp
        tripRepository.deleteById(savedTrip.getId());
    }

    @Test
    public void shouldGrtTripsByType() {
        //Given
        long numbersOfTripsInDbTypePlane = tripService.getAllTrips().stream()
                .filter(trip -> trip.getType().equals(TripType.PLANE))
                .count();

        //When
        List<Trip> tripsByType = tripService.getTripsByType(TripType.PLANE);

        //Then
        assertEquals(numbersOfTripsInDbTypePlane, tripsByType.size());
    }

    @Test
    public void shouldGetTripsByDestination() {
        //Given
        long numbersOfTripsInDbToKuba = tripService.getAllTrips().stream()
                .filter(trip -> trip.getDestination().equals("Kuba"))
                .count();

        //When
        List<Trip> tripsByDestination = tripService.getTripsByDestination("Kuba");

        //Then
        assertEquals(numbersOfTripsInDbToKuba, tripsByDestination.size());
    }

    @Test
    public void shouldGetTripsByStartDate() {
        //Given
        long numberOfTripsWithTheSameStartDate = tripService.getAllTrips().stream()
                .filter(trip -> trip.getStartDate().equals(LocalDate.of(1970, 01, 12)))
                .count();

        //When
        List<Trip> tripsByStartDate = tripService.getTripsByStartDate(LocalDate.of(1970, 01, 12));

        //Then
        assertEquals(numberOfTripsWithTheSameStartDate, tripsByStartDate.size());
    }

    @Test
    public void shouldGetTripsByStopDate() {
        //Given
        long numberOfTripsWithTheSameStopDate = tripService.getAllTrips().stream()
                .filter(trip -> trip.getStopDate().equals(LocalDate.of(1970, 01, 18)))
                .count();

        //When
        List<Trip> tripsByStopDate = tripService.getTripsByStopDate(LocalDate.of(1970, 01, 18));

        //Then
        assertEquals(numberOfTripsWithTheSameStopDate, tripsByStopDate.size());
    }

    @Test
    public void shouldGetAllAvailableDestinations() {
        //Given
        Set<String> destinationsInDb = tripService.getAllTrips().stream()
                .map(trip -> trip.getDestination())
                .collect(Collectors.toSet());

        //When
        Set<String> destinations = tripService.getAllAvailableDestinations();

        //Then
        assertEquals(destinationsInDb.size(), destinations.size());
    }
}