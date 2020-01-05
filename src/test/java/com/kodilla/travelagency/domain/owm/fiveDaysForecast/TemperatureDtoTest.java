package com.kodilla.travelagency.domain.owm.fiveDaysForecast;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TemperatureDtoTest {
    private TemperatureDto temperatureDto = new TemperatureDto(12.5, 7.5, 17.5);

    @Test
    public void testGetTemperatures() {
        //When
        double tempAv = temperatureDto.getAverageDayTemperature();
        double tempMin = temperatureDto.getMinimumDayTemperature();
        double tempMax = temperatureDto.getMaximumDayTemperature();

        //Then
        assertEquals(12.5, tempAv, 0.1);
        assertEquals(7.5, tempMin, 0.1);
        assertEquals(17.5, tempMax, 0.1);
    }
}