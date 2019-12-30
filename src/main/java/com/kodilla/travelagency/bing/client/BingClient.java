package com.kodilla.travelagency.bing.client;

import com.google.gson.Gson;
import com.kodilla.travelagency.bing.config.BingConfig;
import com.kodilla.travelagency.domain.bing.image.ImageResponse;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;

@Component
public class BingClient {

    @Autowired
    private BingConfig bingConfig;

    private URI buildUrl(String cityName) {
        return UriComponentsBuilder.fromHttpUrl(bingConfig.getBingApiEndpoint())
                .queryParam("q", cityName)
                .build().encode().toUri();
    }

    public ImageResponse getImage(String cityName) {

        HttpResponse response;
        String responseString = null;
        HttpClient client = HttpClients.custom().build();
        HttpUriRequest request = RequestBuilder.get()
                .setUri(buildUrl(cityName))
                .setHeader("Ocp-Apim-Subscription-Key",bingConfig.getBingAppKey())
                .build();

        try {
            response = client.execute(request);

            HttpEntity entity = response.getEntity();
            responseString = EntityUtils.toString(entity, "UTF-8");
        } catch (IOException e) {

        }

        Gson gson = new Gson();
        ImageResponse imageResponse = gson.fromJson(responseString, ImageResponse.class);

        return imageResponse;

    }
}
