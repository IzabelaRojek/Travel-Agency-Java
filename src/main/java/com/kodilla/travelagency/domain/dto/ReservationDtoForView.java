package com.kodilla.travelagency.domain.dto;

import com.kodilla.travelagency.domain.TripType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDtoForView {
    private Long id;
    private String userFirstName;
    private String userLastName;
    private String userLogin;
    private String tripName;
    private String tripDestination;
    private LocalDate startDate;
    private LocalDate stopDate;
    private TripType tripType;
    private BigDecimal price;
    private boolean isConfirmed;
}
