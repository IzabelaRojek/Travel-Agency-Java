package com.kodilla.travelagency.service;

import com.kodilla.travelagency.config.AdminConfig;
import com.kodilla.travelagency.domain.Reservation;
import com.kodilla.travelagency.domain.mail.Mail;
import com.kodilla.travelagency.repository.ReservationRepository;
import com.kodilla.travelagency.service.mail.SimpleEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReservationService {

    private static final String SUBJECT_NEW_RESERVATION = "New reservation added.";

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    private SimpleEmailService mailService;

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> getReservation(final Long id) {
        return reservationRepository.findById(id);
    }

    public Reservation saveReservation(final Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public void deleteReservation(final Long id) {
        reservationRepository.deleteById(id);
    }

    public void sendNewReservationEmail(final Reservation reservation) {
        mailService.send(new Mail(adminConfig.getAdminMail(), SUBJECT_NEW_RESERVATION, "Reservation details: " + '\n' + "For: " + '\n' + reservation.getUser() + ", " + reservation.getTrip() ));
    }

    public List<Reservation> getReservationsNotConfirmed(final boolean confirmed) {
        return getAllReservations().stream()
                .filter(r -> r.isConfirmed() == false)
                .collect(Collectors.toList());
    }
}
