package com.kodilla.travelagency.controller.client;

import com.kodilla.travelagency.bing.client.BingClient;
import com.kodilla.travelagency.domain.bing.image.forView.ImagesList;
import com.kodilla.travelagency.domain.bing.image.ImageResponse;
import com.kodilla.travelagency.domain.bing.image.forView.ImagesForView;
import com.kodilla.travelagency.mapper.bing.BingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "bing", produces = "application/json")
public class BingController {

    @Autowired
    private BingClient bingClient;

    @Autowired
    private BingMapper bingMapper;

    @GetMapping("getImage/{cityName}")
    public ImageResponse getImageByCityName(@PathVariable String cityName) {
        return bingClient.getImage(cityName);
    }

    @GetMapping("urls/{cityName}")
    public ImagesList getImage(@PathVariable String cityName) {
        return bingMapper.mapToImageForView(bingClient.getImage(cityName));
    }

    @GetMapping("getUrl/{cityName}")
    public ImagesForView getUrlOfImage(@PathVariable String cityName) {
        return bingMapper.mapToImages(bingClient.getImage(cityName));
    }
}
