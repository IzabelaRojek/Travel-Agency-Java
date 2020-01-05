package com.kodilla.travelagency.domain.owm.fiveDaysForecast;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WeatherDtoTest {
    private WeatherDto weatherDto = new WeatherDto(1L, "testMain", "testDescription");

    @Test
    public void testGetters() {
        //When
        long id = weatherDto.getId();
        String main = weatherDto.getMain();
        String description = weatherDto.getDescription();

        //Then
        assertEquals(1L, id);
        assertEquals("testMain", main);
        assertEquals("testDescription", description);
    }
}