package com.kodilla.travelagency.openWeatherMap.client;

import com.kodilla.travelagency.domain.owm.fiveDaysForecast.ForecastDto;
import com.kodilla.travelagency.openWeatherMap.config.OwmConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class OwmClient {

    @Autowired
    private OwmConfig owmConfig;

    @Autowired
    private RestTemplate restTemplate;

    public ForecastDto getForecast(String cityName, String countryCode) {

       URI url = UriComponentsBuilder.fromHttpUrl(owmConfig.getOwmApiEndpoint() + "/forecast")
               .queryParam("q", cityName + "," + countryCode)
               .queryParam("units", "metric")
               .queryParam("APPID", owmConfig.getOwmAppKey()).build().encode().toUri();

       try {
          ForecastDto forecastResponse = restTemplate.getForObject(url, ForecastDto.class);
          return forecastResponse;
       } catch (RestClientException e) {
          return new ForecastDto();
       }
    }
 }
