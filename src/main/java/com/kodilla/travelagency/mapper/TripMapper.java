package com.kodilla.travelagency.mapper;

import com.kodilla.travelagency.domain.Trip;
import com.kodilla.travelagency.domain.dto.TripDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TripMapper {
    public List<TripDto> mapToTripDtoList(final List<Trip> trips) {
        return trips.stream()
                //.map(t -> new TripDto(t.getId(), t.getName(), t.getDestination(), t.getDescription(), t.getStartDate(), t.getStopDate(), t.getType(), t.getPrice()))
                .map(t -> mapToTripDto(t))
                .collect(Collectors.toList());
    }

    public TripDto mapToTripDto(final Trip trip) {
        return new TripDto(trip.getId(), trip.getName(), trip.getDestination(), trip.getDescription(), trip.getStartDate(), trip.getStopDate(), trip.getType(), trip.getPrice());
    }

    public Trip mapToTrip(final TripDto tripDto) {
        return new Trip(tripDto.getId(), tripDto.getName(), tripDto.getDestination(), tripDto.getDescription(), tripDto.getStartDate(), tripDto.getStopDate(), tripDto.getType(), tripDto.getPrice());
    }
}
