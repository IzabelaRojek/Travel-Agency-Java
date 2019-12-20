package com.kodilla.travelagency.domain.owm;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TemperatureDto {

    @JsonProperty("day")
    private double averageDayTemperature;

    @JsonProperty("min")
    private double minimumDayTemperature;

    @JsonProperty("max")
    private double maximumDayTemperature;

}
