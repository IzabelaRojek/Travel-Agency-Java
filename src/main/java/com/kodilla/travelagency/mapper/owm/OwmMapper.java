package com.kodilla.travelagency.mapper.owm;

import com.kodilla.travelagency.domain.owm.currentWeather.WeatherResponse;
import com.kodilla.travelagency.domain.owm.fiveDaysForecast.ForecastDto;
import com.kodilla.travelagency.domain.owm.fiveDaysForecast.MainDetailsDto;
import com.kodilla.travelagency.domain.owm.forView.CurrentWeather;
import com.kodilla.travelagency.domain.owm.forView.ShortForecast;
import com.kodilla.travelagency.domain.owm.forView.ShortMainDetails;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OwmMapper {

    public ShortForecast matToForecast(ForecastDto forecastDto) {
        List<MainDetailsDto> details =  forecastDto.getList().stream()
                .map(e -> e.getMainDetails())
                .collect(Collectors.toList());
        return new ShortForecast(mapToShortList(details));
    }

    public List<ShortMainDetails> mapToShortList(List<MainDetailsDto> details) {
        return details.stream()
                .map(e -> new ShortMainDetails(e.getTemperature(), e.getTemperatureFeelsLike()))
                .collect(Collectors.toList());
    }

    /*public CurrentWeather mapToCurrentWeather(WeatherResponse weatherResponse) {
        return new CurrentWeather(weatherResponse.getWeather().);
    }*/

    public List<Object> mapArrayToList(Object[] objArray) {
        return null;
    }

}
