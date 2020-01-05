package com.kodilla.travelagency.mapper;

import com.kodilla.travelagency.domain.Complaint;
import com.kodilla.travelagency.domain.dto.ComplaintDto;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ComplaintMapperTest {
    private ComplaintMapper complaintMapper = new ComplaintMapper();

    @Test
    public void testMapToComplaint() {
        //Given
        ComplaintDto complaintDto = new ComplaintDto(1L, "testTopic", "testContent", "testEmail");

        //When
        Complaint complaint = complaintMapper.mapToComplaint(complaintDto);

        //Then
        assertEquals("testTopic", complaint.getTopic());
    }

    @Test
    public void testMapToComplaintDtoList() {
        //Given
        Complaint complaint1 = new Complaint(1L, "testTopic1", "testContent1", "testEmail1");
        Complaint complaint2 = new Complaint(2L, "testTopic2", "testContent2", "testEmail2");
        List<Complaint> complaints = new ArrayList<>();
        complaints.add(complaint1);
        complaints.add(complaint2);

        //When
        List<ComplaintDto> complaintDtoList = complaintMapper.mapToComplaintDtoList(complaints);

        //Then
        assertEquals(2, complaintDtoList.size());
        assertEquals(complaints.get(0).getId(), complaintDtoList.get(0).getId());
    }
}