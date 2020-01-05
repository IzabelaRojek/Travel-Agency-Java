package com.kodilla.travelagency.controller;

import com.kodilla.travelagency.domain.dto.ComplaintDto;
import com.kodilla.travelagency.mapper.ComplaintMapper;
import com.kodilla.travelagency.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@Transactional
@RequestMapping(value = "complaint", produces = "application/json")
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    @Autowired
    private ComplaintMapper complaintMapper;

    @PostMapping(value = "create", consumes = APPLICATION_JSON_VALUE)
    public void createAndSendComplaint(final ComplaintDto complaintDto) {
        complaintService.saveComplaint(complaintMapper.mapToComplaint(complaintDto));
        complaintService.sendComplaint(complaintMapper.mapToComplaint(complaintDto));
    }

    @GetMapping(value = "getAll")
    public List<ComplaintDto> getComplaints() {
        return complaintMapper.mapToComplaintDtoList(complaintService.getAllComplaints());
    }
}
