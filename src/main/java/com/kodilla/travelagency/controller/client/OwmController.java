package com.kodilla.travelagency.controller.client;

import com.kodilla.travelagency.domain.owm.ForecastDto;
import com.kodilla.travelagency.openWeatherMap.client.OwmClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "owm")
public class OwmController {

    @Autowired
    private OwmClient owmClient;

    @GetMapping("getForecast/{cityName},{countryCode}")
    public ForecastDto getForecastByCityNameAndCountryCode(@PathVariable String cityName, @PathVariable String countryCode) {
        return owmClient.getForecast(cityName, countryCode);
    }
}
