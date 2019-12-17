package com.kodilla.travelagency.scheduler;

import com.kodilla.travelagency.config.AdminConfig;
import com.kodilla.travelagency.domain.Reservation;
import com.kodilla.travelagency.domain.mail.Mail;
import com.kodilla.travelagency.service.ReservationService;
import com.kodilla.travelagency.service.mail.SimpleEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmailScheduler {

    private static final String SUBJECT = "Not confirmed reservations";

    @Autowired
    private SimpleEmailService mailService;

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    private ReservationService reservationService;

    //@Scheduled(fixedDelay =  10000)
    @Scheduled(cron = "0 0 9 * * *")
    public void sendInformationEmail() {
        List<Reservation> reservationsNotConfirmed = reservationService.getReservationsNotConfirmed(false);
        if (reservationsNotConfirmed.size() > 0) {
            mailService.send(new Mail(adminConfig.getAdminMail(), SUBJECT, createMessageText(reservationsNotConfirmed)));
        }
    }

    private String createMessageText(List<Reservation> reservations) {
        if (reservations.size() > 1) {
            return "There are " + reservations.size() + " not confirmed reservations: " + '\n' + reservations;
        } else {
            return "There is one not confirmed reservation: " + reservations;
        }
    }
}
