package com.kodilla.travelagency.domain.owm.forView;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CurrentWeather {
    private String main;
    private String description;
    private double temperature;
    private double tempFeelsLike;
}
