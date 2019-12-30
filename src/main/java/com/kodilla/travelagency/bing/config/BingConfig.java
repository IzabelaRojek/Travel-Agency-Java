package com.kodilla.travelagency.bing.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class BingConfig {

    @Value("${bing.api.endpoint.prod}")
    private String bingApiEndpoint;

    @Value("${bing.app.key}")
    private String bingAppKey;
}
