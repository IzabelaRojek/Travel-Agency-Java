package com.kodilla.travelagency.domain.owm.fiveDaysForecast;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;

public class CloudDtoTest {
    private CloudDto cloudDto = new CloudDto(12.5);

    @Test
    public void testGetCloudiness() {
        //When
        double cloudiness = cloudDto.getCloudiness();

        //Then
        assertEquals(12.5, cloudiness, 0.1);
    }
}