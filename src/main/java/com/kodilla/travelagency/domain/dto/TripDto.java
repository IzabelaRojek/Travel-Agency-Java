package com.kodilla.travelagency.domain.dto;

import com.kodilla.travelagency.domain.Reservation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TripDto {
    private Long id;
    private String name;
    private String destination;
    private String description;
    private LocalDate startDate;
    private LocalDate stopDate;
    private String type;
    private BigDecimal price;
    private List<Reservation> reservations;

    public TripDto(Long id, String name, String destination, String description, LocalDate startDate, LocalDate stopDate, String type, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.destination = destination;
        this.description = description;
        this.startDate = startDate;
        this.stopDate = stopDate;
        this.type = type;
        this.price = price;
    }
}
