package com.kodilla.travelagency.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ComplaintDto {
    private Long id;
    private String topic;
    private String content;
    private String email;
}
