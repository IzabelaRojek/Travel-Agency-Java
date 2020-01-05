package com.kodilla.travelagency.controller;

import com.google.gson.Gson;
import com.kodilla.travelagency.domain.Reservation;
import com.kodilla.travelagency.domain.Trip;
import com.kodilla.travelagency.domain.TripType;
import com.kodilla.travelagency.domain.User;
import com.kodilla.travelagency.domain.dto.ReservationDto;
import com.kodilla.travelagency.domain.dto.ReservationDtoForView;
import com.kodilla.travelagency.domain.dto.TripDto;
import com.kodilla.travelagency.domain.dto.UserDto;
import com.kodilla.travelagency.mapper.ReservationMapper;
import com.kodilla.travelagency.repository.TripRepository;
import com.kodilla.travelagency.repository.UserRepository;
import com.kodilla.travelagency.service.LogService;
import com.kodilla.travelagency.service.ReservationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.floatThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ReservationController.class)
public class ReservationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReservationMapper reservationMapper;

    @MockBean
    private ReservationService reservationService;

    @MockBean
    private LogService logService;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private TripRepository tripRepository;

    @Test
    public void shouldGetEmptyListOfReservations() throws Exception {
        //Given
        List<ReservationDtoForView> reservationDtoList = new ArrayList<>();
        List<Reservation> reservations = new ArrayList<>();
        when(reservationMapper.mapToReservationDtoForViewList(reservations)).thenReturn(reservationDtoList);
        when(reservationService.getAllReservations()).thenReturn(reservations);

        //When & Then
        mockMvc.perform(get("/reservation/getAll").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }


    @Test
    public void shouldGetAllReservations() throws Exception {
        //Given
        User user = new User(1L, "fn1test", "ln1test", "login1Test", "password1Test", "user1@test");
        Trip trip1 = new Trip(1L, "trip1name", "destination1", "desc1", LocalDate.of(2019, 12, 11), LocalDate.of(2019, 12, 18), TripType.PLANE, new BigDecimal(3500));
        Trip trip2 = new Trip(2L, "trip2name", "destination2", "desc2", LocalDate.of(2020, 01, 10), LocalDate.of(2020, 01, 17), TripType.PLANE, new BigDecimal(3500));
        Reservation reservation1 = new Reservation(1L, user, trip1, false);
        Reservation reservation2 = new Reservation(2L, user, trip2, false);

        List<Reservation> reservations = new ArrayList<>();
        reservations.add(reservation1);
        reservations.add(reservation2);

        UserDto userDto = new UserDto(1L, "fn1test", "ln1test", "login1Test", "password1Test", "user1@test");
        TripDto tripDto1 = new TripDto(1L, "trip1name", "destination1", "desc1", LocalDate.of(2019, 12, 11), LocalDate.of(2019, 12, 18), TripType.PLANE, new BigDecimal(3500));
        TripDto tripDto2 = new TripDto(2L, "trip2name", "destination2", "desc2", LocalDate.of(2020, 01, 10), LocalDate.of(2020, 01, 17), TripType.PLANE, new BigDecimal(3500));
        //ReservationDto reservationDto1 = new ReservationDto(1L, userDto.getId(), tripDto1.getId(), false);
        //ReservationDto reservationDto2 = new ReservationDto(2L, userDto.getId(), tripDto2.getId(), false);

        ReservationDtoForView reservationDtoForView1 = new ReservationDtoForView(1L, userDto.getFirstname(), userDto.getLastname(), userDto.getLogin(), tripDto1.getName(), tripDto1.getDestination(), tripDto1.getStartDate(), tripDto1.getStopDate(), tripDto1.getType(), tripDto1.getPrice(), false);
        ReservationDtoForView reservationDtoForView2 = new ReservationDtoForView(2L, userDto.getFirstname(), userDto.getLastname(), userDto.getLogin(), tripDto2.getName(), tripDto2.getDestination(), tripDto2.getStartDate(), tripDto2.getStopDate(), tripDto2.getType(), tripDto2.getPrice(), false);

        //List<ReservationDto> reservationDtoList = new ArrayList<>();
        //reservationDtoList.add(reservationDto1);
        //reservationDtoList.add(reservationDto2);

        List<ReservationDtoForView> reservationDtoForViewList = new ArrayList<>();
        reservationDtoForViewList.add(reservationDtoForView1);
        reservationDtoForViewList.add(reservationDtoForView2);

        when(reservationMapper.mapToReservationDtoForViewList(reservations)).thenReturn(reservationDtoForViewList);
        when(reservationService.getAllReservations()).thenReturn(reservations);

        //When & Then
        mockMvc.perform(get("/reservation/getAll").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    public void shouldGetReservationById() throws Exception {
        //Given
        User user = new User(1L, "fn1test", "ln1test", "login1Test", "password1Test", "user1@test");
        Trip trip1 = new Trip(1L, "trip1name", "destination1", "desc1", LocalDate.of(2019, 12, 11), LocalDate.of(2019, 12, 18), TripType.PLANE, new BigDecimal(3500));
        Reservation reservation1 = new Reservation(1L, user, trip1, false);

        UserDto userDto = new UserDto(1L, "fn1test", "ln1test", "login1Test", "password1Test", "user1@test");
        TripDto tripDto1 = new TripDto(1L, "trip1name", "destination1", "desc1", LocalDate.of(2019, 12, 11), LocalDate.of(2019, 12, 18), TripType.PLANE, new BigDecimal(3500));
        ReservationDto reservationDto1 = new ReservationDto(1L, userDto.getId(), tripDto1.getId(), false);


        when(reservationMapper.mapToReservationDto(reservation1)).thenReturn(reservationDto1);
        when(reservationService.getReservation(1L)).thenReturn(Optional.of(reservation1));

        //When & Then
        mockMvc.perform(get("/reservation/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.userId", is(1)));
    }

    @Test
    public void shouldAddReservation() throws Exception {
        //Given
        User user = new User(1L, "fn1test", "ln1test", "login1Test", "password1Test", "user1@test");
        Trip trip1 = new Trip(1L, "trip1name", "destination1", "desc1", LocalDate.of(2019, 12, 11), LocalDate.of(2019, 12, 18), TripType.PLANE, new BigDecimal(3500));
        Reservation reservation1 = new Reservation(1L, user, trip1, false);

        UserDto userDto = new UserDto(1L, "fn1test", "ln1test", "login1Test", "password1Test", "user1@test");
        TripDto tripDto1 = new TripDto(1L, "trip1name", "destination1", "desc1", LocalDate.of(2019, 12, 11), LocalDate.of(2019, 12, 18), TripType.PLANE, new BigDecimal(3500));
        ReservationDto reservationDto1 = new ReservationDto(1L, userDto.getId(), tripDto1.getId(), false);

        when(reservationService.saveReservation(reservation1)).thenReturn(reservation1);
        when(reservationMapper.mapToReservation(reservationDto1)).thenReturn(reservation1);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(reservationDto1);

        //When & Then
        mockMvc.perform(post("/reservation/").contentType(MediaType.APPLICATION_JSON)
            .characterEncoding("UTF-8")
            .content(jsonContent))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldUpdateReservation() throws Exception {
        //Given
        User user = new User(1L, "fn1test", "ln1test", "login1Test", "password1Test", "user1@test");
        Trip trip1 = new Trip(1L, "trip1name", "destination1", "desc1", LocalDate.of(2019, 12, 11), LocalDate.of(2019, 12, 18), TripType.PLANE, new BigDecimal(3500));
        Reservation reservation1 = new Reservation(1L, user, trip1, false);

        UserDto userDto = new UserDto(1L, "fn1test", "ln1test", "login1Test", "password1Test", "user1@test");
        TripDto tripDto1 = new TripDto(1L, "trip1name", "destination1", "desc1", LocalDate.of(2019, 12, 11), LocalDate.of(2019, 12, 18), TripType.PLANE, new BigDecimal(3500));
        ReservationDto reservationDto1 = new ReservationDto(1L, userDto.getId(), tripDto1.getId(), false);

        when(reservationMapper.mapToReservation(reservationDto1)).thenReturn(reservation1);
        when(reservationService.saveReservation(reservation1)).thenReturn(reservation1);
        when(reservationMapper.mapToReservationDto(reservation1)).thenReturn(reservationDto1);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(reservationDto1);

        //When & Then
        mockMvc.perform(put("/reservation/update").contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldDeleteReservation() throws Exception {
        //Given
        User user = new User(1L, "fn1test", "ln1test", "login1Test", "password1Test", "user1@test");
        Trip trip1 = new Trip(1L, "trip1name", "destination1", "desc1", LocalDate.of(2019, 12, 11), LocalDate.of(2019, 12, 18), TripType.PLANE, new BigDecimal(3500));
        Reservation reservation1 = new Reservation(1L, user, trip1, false);

        reservationService.saveReservation(reservation1);

        //When & Then
        mockMvc.perform(delete("/reservation/1/delete").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}