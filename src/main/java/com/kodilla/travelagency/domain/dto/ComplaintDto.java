package com.kodilla.travelagency.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ComplaintDto {
    private Long id;
    private String topic;
    private String content;
    private String email;
}
