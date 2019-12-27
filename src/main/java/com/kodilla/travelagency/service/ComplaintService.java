package com.kodilla.travelagency.service;

import com.kodilla.travelagency.config.AdminConfig;
import com.kodilla.travelagency.domain.Complaint;
import com.kodilla.travelagency.domain.mail.Mail;
import com.kodilla.travelagency.repository.ComplaintRepository;
import com.kodilla.travelagency.service.mail.SimpleEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComplaintService {

    private static final String SUBJECT = "New complaint: ";
    @Autowired
    private ComplaintRepository complaintRepository;

    @Autowired
    private SimpleEmailService mailService;

    @Autowired
    private AdminConfig adminConfig;

    public Complaint saveComplaint(final Complaint complaint) {
        return complaintRepository.save(complaint);
    }

    public void sendComplaint(final Complaint complaint) {
        mailService.send(new Mail(adminConfig.getAdminMail(), SUBJECT + complaint.getTopic(), "Complaint: " + '\n' + "   " + complaint.getContent()));
    }
}
