package com.kodilla.travelagency.domain.dto;

import com.kodilla.travelagency.domain.TripType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

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
    private TripType type;
    private BigDecimal price;


}
