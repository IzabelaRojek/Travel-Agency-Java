package com.kodilla.travelagency.mapper;

import com.kodilla.travelagency.domain.Complaint;
import com.kodilla.travelagency.domain.dto.ComplaintDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ComplaintMapper {
    public Complaint mapToComplaint(ComplaintDto complaintDto) {
        return new Complaint(complaintDto.getId(), complaintDto.getTopic(), complaintDto.getContent(), complaintDto.getEmail());
    }

    public ComplaintDto mapToComplaintDto(Complaint complaint) {
        return new ComplaintDto(complaint.getId(), complaint.getTopic(), complaint.getContent(), complaint.getEmail());
    }

    public List<ComplaintDto> mapToComplaintDtoList(final List<Complaint> complaints) {
        return complaints.stream()
                .map(c -> mapToComplaintDto(c))
                .collect(Collectors.toList());
    }
}
