package com.kodilla.travelagency.mapper;

import com.kodilla.travelagency.domain.Trip;
import com.kodilla.travelagency.domain.TripType;
import com.kodilla.travelagency.domain.dto.TripDto;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TripMapperTest {
    private TripMapper tripMapper = new TripMapper();

    @Test
    public void testMapToTripDtoList() {
        //Given
        Trip trip1 = new Trip(1L, "trip1name", "destination1", "desc1", LocalDate.of(2019, 12, 11), LocalDate.of(2019, 12, 18), TripType.PLANE, new BigDecimal(3500));
        Trip trip2 = new Trip(2L, "trip1name", "destination1", "desc1", LocalDate.of(2019, 12, 11), LocalDate.of(2019, 12, 25), TripType.PLANE, new BigDecimal(4500));
        List<Trip> trips = new ArrayList<>();
        trips.add(trip1);
        trips.add(trip2);

        //When
        List<TripDto> tripDtoList = tripMapper.mapToTripDtoList(trips);

        //Then
        assertEquals(2, tripDtoList.size());
        assertEquals(trips.get(0).getId(), tripDtoList.get(0).getId());
    }

    @Test
    public void testMapToTrip() {
        //Given
        TripDto tripDto = new TripDto(1L, "trip1name", "destination1", "desc1", LocalDate.of(2019, 12, 11), LocalDate.of(2019, 12, 18), TripType.PLANE, new BigDecimal(3500));

        //When
        Trip trip = tripMapper.mapToTrip(tripDto);

        //Then
        assertEquals("desc1", trip.getDescription());
    }

}
