package com.kodilla.travelagency.controller;

import com.google.gson.Gson;
import com.kodilla.travelagency.domain.Trip;
import com.kodilla.travelagency.domain.TripType;
import com.kodilla.travelagency.domain.dto.TripDto;
import com.kodilla.travelagency.mapper.TripMapper;
import com.kodilla.travelagency.service.TripService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TripController.class)
public class TripControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TripMapper tripMapper;

    @MockBean
    private TripService tripService;

    @Test
    public void shouldGetEmptyListOfTrips() throws Exception {
        //Given
        List<Trip> trips = new ArrayList<>();
        List<TripDto> tripDtoList = new ArrayList<>();

        when(tripMapper.mapToTripDtoList(trips)).thenReturn(tripDtoList);
        when(tripService.getAllTrips()).thenReturn(trips);

        //When & Then
        mockMvc.perform(get("/trip/getAll").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void shouldGetAllTrips() throws Exception {
        //Given
        List<Trip> trips = new ArrayList<>();
        trips.add(new Trip(1L, "trip1name", "destination1", "desc1", LocalDate.of(2019, 12, 11), LocalDate.of(2019, 12, 18), TripType.PLANE, new BigDecimal(3500)));
        trips.add(new Trip(2L, "trip1name", "destination1", "desc1", LocalDate.of(2019, 12, 11), LocalDate.of(2019, 12, 25), TripType.PLANE, new BigDecimal(4500)));

        List<TripDto> tripDtoList = new ArrayList<>();
        tripDtoList.add(new TripDto(1L, "trip1name", "destination1", "desc1", LocalDate.of(2019, 12, 11), LocalDate.of(2019, 12, 18), TripType.PLANE, new BigDecimal(3500)));
        tripDtoList.add(new TripDto(2L, "trip1name", "destination1", "desc1", LocalDate.of(2019, 12, 11), LocalDate.of(2019, 12, 25), TripType.PLANE, new BigDecimal(4500)));

        when(tripMapper.mapToTripDtoList(trips)).thenReturn(tripDtoList);
        when(tripService.getAllTrips()).thenReturn(trips);

        //When & Then
        mockMvc.perform(get("/trip/getAll").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    public void shouldGetTripById() throws Exception {
        //Given
        Trip trip = new Trip(1L, "trip1name", "destination1", "desc1", LocalDate.of(2019, 12, 11), LocalDate.of(2019, 12, 18), TripType.PLANE, new BigDecimal(3500));
        TripDto tripDto = new TripDto(1L, "trip1name", "destination1", "desc1", LocalDate.of(2019, 12, 11), LocalDate.of(2019, 12, 18), TripType.PLANE, new BigDecimal(3500));

        when(tripService.getTripById(1L)).thenReturn(Optional.of(trip));
        when(tripMapper.mapToTripDto(trip)).thenReturn(tripDto);

        //When & Then
        mockMvc.perform(get("/trip/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)));
    }

    @Test
    public void shouldGetTripsByType() throws Exception {
        //Given
        List<Trip> trips = new ArrayList<>();
        trips.add(new Trip(1L, "trip1name", "destination1", "desc1", LocalDate.of(2019, 12, 11), LocalDate.of(2019, 12, 18), TripType.PLANE, new BigDecimal(3500)));
        trips.add(new Trip(2L, "trip1name", "destination1", "desc1", LocalDate.of(2019, 12, 11), LocalDate.of(2019, 12, 25), TripType.PLANE, new BigDecimal(4500)));

        List<TripDto> tripDtoList = new ArrayList<>();
        tripDtoList.add(new TripDto(1L, "trip1name", "destination1", "desc1", LocalDate.of(2019, 12, 11), LocalDate.of(2019, 12, 18), TripType.PLANE, new BigDecimal(3500)));
        tripDtoList.add(new TripDto(2L, "trip1name", "destination1", "desc1", LocalDate.of(2019, 12, 11), LocalDate.of(2019, 12, 25), TripType.PLANE, new BigDecimal(4500)));

        when(tripService.getTripsByType(TripType.PLANE)).thenReturn(trips);
        when(tripMapper.mapToTripDtoList(trips)).thenReturn(tripDtoList);

        //When & Then
        mockMvc.perform(get("/trip/getByType/PLANE").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].type", is("PLANE")));
    }

    @Ignore
    @Test
    public void shouldGetTripsByStartDate() throws Exception {
        //Given
        List<Trip> trips = new ArrayList<>();
        trips.add(new Trip(1L, "trip1name", "destination1", "desc1", LocalDate.of(2019, 12, 11), LocalDate.of(2019, 12, 18), TripType.PLANE, new BigDecimal(3500)));
        trips.add(new Trip(2L, "trip1name", "destination1", "desc1", LocalDate.of(2019, 12, 11), LocalDate.of(2019, 12, 25), TripType.PLANE, new BigDecimal(4500)));

        List<TripDto> tripDtoList = new ArrayList<>();
        tripDtoList.add(new TripDto(1L, "trip1name", "destination1", "desc1", LocalDate.of(2019, 12, 11), LocalDate.of(2019, 12, 18), TripType.PLANE, new BigDecimal(3500)));
        tripDtoList.add(new TripDto(2L, "trip1name", "destination1", "desc1", LocalDate.of(2019, 12, 11), LocalDate.of(2019, 12, 25), TripType.PLANE, new BigDecimal(4500)));

        when(tripService.getTripsByStartDate(LocalDate.of(2019, 12, 11))).thenReturn(trips);
        when(tripMapper.mapToTripDtoList(trips)).thenReturn(tripDtoList);

        //When & Then
        mockMvc.perform(get("/trip/getByStartDate/'2019-12-11'").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
                //.andExpect(jsonPath("$[0].type", is("PLANE")));
    }

    @Test
    public void shouldGetTripsByDestination() throws Exception {
        //Given
        List<Trip> trips = new ArrayList<>();
        trips.add(new Trip(1L, "trip1name", "destination1", "desc1", LocalDate.of(2019, 12, 11), LocalDate.of(2019, 12, 18), TripType.PLANE, new BigDecimal(3500)));
        trips.add(new Trip(2L, "trip1name", "destination1", "desc1", LocalDate.of(2019, 12, 11), LocalDate.of(2019, 12, 25), TripType.PLANE, new BigDecimal(4500)));

        List<TripDto> tripDtoList = new ArrayList<>();
        tripDtoList.add(new TripDto(1L, "trip1name", "destination1", "desc1", LocalDate.of(2019, 12, 11), LocalDate.of(2019, 12, 18), TripType.PLANE, new BigDecimal(3500)));
        tripDtoList.add(new TripDto(2L, "trip1name", "destination1", "desc1", LocalDate.of(2019, 12, 11), LocalDate.of(2019, 12, 25), TripType.PLANE, new BigDecimal(4500)));

        when(tripService.getTripsByDestination("destination1")).thenReturn(trips);
        when(tripMapper.mapToTripDtoList(trips)).thenReturn(tripDtoList);

        //When & Then
        mockMvc.perform(get("/trip/getByDest/destination1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Ignore
    @Test
    public void shouldCreateTrip() throws Exception {
        //Given
        Trip trip = new Trip(1L, "trip1name", "destination1", "desc1", LocalDate.of(2019, 12, 11), LocalDate.of(2019, 12, 18), TripType.PLANE, new BigDecimal(3500));
        TripDto tripDto = new TripDto(1L, "trip1name", "destination1", "desc1", LocalDate.of(2019, 12, 11), LocalDate.of(2019, 12, 18), TripType.PLANE, new BigDecimal(3500));

        when(tripService.saveTrip(trip)).thenReturn(trip);
        when(tripMapper.mapToTripDto(trip)).thenReturn(tripDto);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(tripDto);

        //When & Then
        mockMvc.perform(post("/trip/create").contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                    .andExpect(status().is(200));
    }

    @Ignore
    @Test
    public void shouldUpdateTrip() throws Exception {
        //Given
        Trip trip = new Trip(1L, "trip1name", "destination1", "desc1", LocalDate.of(2019, 12, 11), LocalDate.of(2019, 12, 18), TripType.PLANE, new BigDecimal(3500));
        TripDto tripDto = new TripDto(1L, "trip1name", "destination1", "desc1", LocalDate.of(2019, 12, 11), LocalDate.of(2019, 12, 18), TripType.PLANE, new BigDecimal(3500));

        when(tripMapper.mapToTrip(tripDto)).thenReturn(trip);
        when(tripService.saveTrip(trip)).thenReturn(trip);
        when(tripMapper.mapToTripDto(trip)).thenReturn(tripDto);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(tripDto);

        //When & Then
        mockMvc.perform(put("/trip/update").contentType(MediaType.APPLICATION_JSON)
        .characterEncoding("UTF-8")
        .content(jsonContent))
                .andExpect(status().isOk());
    }
}