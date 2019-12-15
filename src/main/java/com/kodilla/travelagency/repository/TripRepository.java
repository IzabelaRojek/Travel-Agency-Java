package com.kodilla.travelagency.repository;

import com.kodilla.travelagency.domain.Trip;
import com.kodilla.travelagency.domain.TripType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface TripRepository extends CrudRepository<Trip, Long> {

    @Override
    List<Trip> findAll();

    @Override
    Optional<Trip> findById(Long id);

    @Override
    Trip save(Trip trip);

    List<Trip> findByStartDate(LocalDate date);

    List<Trip> findByStopDate(LocalDate date);

    List<Trip> findByDestination(String destination);

    List<Trip> findByType(TripType type);






}
