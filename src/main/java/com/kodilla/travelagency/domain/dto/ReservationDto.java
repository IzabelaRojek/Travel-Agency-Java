package com.kodilla.travelagency.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDto {
    private Long id;
    private Long userId;
    private Long tripId;
    private boolean isConfirmed;
}
