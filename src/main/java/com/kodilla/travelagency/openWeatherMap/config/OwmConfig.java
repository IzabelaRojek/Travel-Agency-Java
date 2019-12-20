package com.kodilla.travelagency.openWeatherMap.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class OwmConfig {
    @Value("${owm.api.endpoint.prod}")
    private String owmApiEndpoint;

    @Value("${owm.app.key}")
    private String owmAppKey;
}
