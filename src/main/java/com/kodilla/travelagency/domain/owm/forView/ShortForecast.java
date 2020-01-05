package com.kodilla.travelagency.domain.owm.forView;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ShortForecast {

    private List<ShortMainDetails> details;
}
