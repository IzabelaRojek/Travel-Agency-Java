package com.kodilla.travelagency.mapper.bing;

import com.kodilla.travelagency.domain.bing.image.forView.ImagesList;
import com.kodilla.travelagency.domain.bing.image.ImageResponse;
import com.kodilla.travelagency.domain.bing.image.forView.ImagesForView;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BingMapper {

    private String[] getStringArray(List<String> list) {
        String strings[] = new String[list.size()];
        Object[] objArray = list.toArray();

        int i = 0;
        for (Object object : objArray) {
            strings[i++] = (String)object;
        }

        return strings;
    }

    public ImagesList mapToImageForView(ImageResponse response) {
        List<String> urls = Arrays.stream(response.getValue())
                .map(e -> e.getThumbnailUrl())
                .collect(Collectors.toList());

        String strings[] = getStringArray(urls);

        return new ImagesList(strings);
    }

    public ImagesForView mapToImages(ImageResponse response) {
        return new ImagesForView(response.getWebSearchUrl());
    }
}
