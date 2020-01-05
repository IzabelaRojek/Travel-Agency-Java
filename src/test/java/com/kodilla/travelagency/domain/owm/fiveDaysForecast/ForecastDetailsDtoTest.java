package com.kodilla.travelagency.domain.owm.fiveDaysForecast;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ForecastDetailsDtoTest {
    private MainDetailsDto mainDetailsDto = new MainDetailsDto(12.5, 9.8, 80.5);
    private CloudDto cloudDto = new CloudDto(12.5);
    private WindDto windDto = new WindDto(5.3);
    private ForecastDetailsDto forecastDetailsDto = new ForecastDetailsDto("dtTest", mainDetailsDto, new ArrayList<>(), cloudDto, windDto, "d&TTest");

    @Test
    public void testGetDt() {
        //When
        String dt = forecastDetailsDto.getDt();

        //Then
        assertEquals("dtTest", dt);
    }

    @Test
    public void testGetWindDto() {
        //When
        double speed = forecastDetailsDto.getWind().getWindSpeed();

        //Then
        assertEquals(5.3, speed, 0.1);
    }

    @Test
    public void testGetWeatherList() {
        //When
        int size = forecastDetailsDto.getWeatherList().size();

        //Then
        assertEquals(0, size);
    }

    @Test
    public void testGetDateAndTime() {
        //When
        String string = forecastDetailsDto.getDateAndTime();

        //Then
        assertEquals("d&TTest", string);
    }

}