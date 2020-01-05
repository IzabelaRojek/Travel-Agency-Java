package com.kodilla.travelagency.service.owm;

import com.kodilla.travelagency.domain.owm.fiveDaysForecast.ForecastDto;
import com.kodilla.travelagency.openWeatherMap.client.OwmClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwmService {

    @Autowired
    private OwmClient owmClient;

    public ForecastDto retrieveForecast(final String cityName, final String countryCode) {
        return owmClient.getForecast(cityName, countryCode);
    }
}
