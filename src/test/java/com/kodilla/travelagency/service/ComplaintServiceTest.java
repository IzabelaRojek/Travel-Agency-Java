package com.kodilla.travelagency.service;

import com.kodilla.travelagency.domain.Complaint;
import com.kodilla.travelagency.repository.ComplaintRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ComplaintServiceTest {

    @Autowired
    private ComplaintService complaintService;

    @Autowired
    private ComplaintRepository complaintRepository;

    @Test
    public void shouldGetAllComplaints() {
        //Given
        long numberOfComplaintsInDb = complaintRepository.count();

        ///When
        List<Complaint> complaints = complaintService.getAllComplaints();

        //Then
        assertEquals(numberOfComplaintsInDb, complaints.size());
    }

    @Test
    public void shouldSaveTrip() {
        //Given
        Complaint complaint1 = new Complaint(1L, "testTopic1", "testContent1", "testEmail1");

        //When
        Complaint savedComplaint = complaintService.saveComplaint(complaint1);
        Optional<Complaint> readComplaint = complaintRepository.findById(savedComplaint.getId());

        //Then
        List<Complaint> complaints = complaintService.getAllComplaints();
        assertEquals(complaintRepository.count(), complaints.size());
        assertTrue(readComplaint.isPresent());

        //CleanUp
        complaintRepository.deleteById(savedComplaint.getId());
    }
}