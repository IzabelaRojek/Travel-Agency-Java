package com.kodilla.travelagency.repository;

import com.kodilla.travelagency.domain.Reservation;
import com.kodilla.travelagency.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface ReservationRepository extends CrudRepository<Reservation, Long> {

    @Override
    List<Reservation> findAll();

    @Override
    Optional<Reservation> findById(Long id);

    @Override
    Reservation save(Reservation reservation);

    @Override
    void deleteById(Long id);

    Optional<Reservation> findByUser(User user);

    Optional<Reservation> findByUser_Id(Long id);

}
