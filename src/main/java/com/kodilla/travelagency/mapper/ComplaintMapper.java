package com.kodilla.travelagency.mapper;

import com.kodilla.travelagency.domain.Complaint;
import com.kodilla.travelagency.domain.dto.ComplaintDto;
import org.springframework.stereotype.Component;

@Component
public class ComplaintMapper {
    public Complaint mapToComplaint(ComplaintDto complaintDto) {
        return new Complaint(complaintDto.getId(), complaintDto.getTopic(), complaintDto.getContent(), complaintDto.getEmail());
    }

    public ComplaintDto mapToComplaintDto(Complaint complaint) {
        return new ComplaintDto(complaint.getId(), complaint.getTopic(), complaint.getContent(), complaint.getEmail());
    }
}
