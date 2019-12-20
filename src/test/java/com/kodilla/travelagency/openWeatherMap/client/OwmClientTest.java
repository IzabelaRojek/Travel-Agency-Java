package com.kodilla.travelagency.openWeatherMap.client;

import com.kodilla.travelagency.domain.owm.CityDto;
import com.kodilla.travelagency.domain.owm.ForecastDto;
import com.kodilla.travelagency.openWeatherMap.config.OwmConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class OwmClientTest {

    @InjectMocks
    private OwmClient owmClient;

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private OwmConfig owmConfig;

    @Test
    public void shouldGetForecast() throws URISyntaxException {
        //Given
        when(owmConfig.getOwmApiEndpoint()).thenReturn("http://test.com");
        when(owmConfig.getOwmAppKey()).thenReturn("testKey");

        CityDto city = new CityDto(1L, "testName", "testCountryCode");
        ForecastDto forecastDto = new ForecastDto(city, new ArrayList<>());

        URI uri = new URI("http://test.com?q=testName,testCountryCode&units=metric&APPID=testKey");

        when(restTemplate.getForObject(uri, ForecastDto.class)).thenReturn(forecastDto);

        //When
        ForecastDto forecastResponse = owmClient.getForecast("testName", "testCountryCode");

        //Then
        assertEquals(1, forecastResponse.getCity().getId());
        assertEquals("testName", forecastResponse.getCity().getName());
        assertEquals("testCountryCode", forecastResponse.getCity().getCountryCode());
        assertEquals(new ArrayList<>(), forecastResponse.getList());
    }

}