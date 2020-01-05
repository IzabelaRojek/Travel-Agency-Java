package com.kodilla.travelagency.domain.owm.fiveDaysForecast;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ForecastDetailsDto {

    @JsonProperty("dt")
    private String dt;

    @JsonProperty("main")
    private MainDetailsDto mainDetails;

    @JsonProperty("weather")
    private List<WeatherDto> weatherList;

    @JsonProperty("clouds")
    private CloudDto cloud;

    @JsonProperty("wind")
    private WindDto wind;

    @JsonProperty("dt_txt")
    private String dateAndTime;

}
