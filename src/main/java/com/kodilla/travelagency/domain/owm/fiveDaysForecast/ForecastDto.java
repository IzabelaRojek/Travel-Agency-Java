package com.kodilla.travelagency.domain.owm.fiveDaysForecast;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kodilla.travelagency.domain.owm.fiveDaysForecast.CityDto;
import com.kodilla.travelagency.domain.owm.fiveDaysForecast.ForecastDetailsDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ForecastDto {
    @JsonProperty("city")
    private CityDto city;

    @JsonProperty("list")
    private List<ForecastDetailsDto> list;
}


