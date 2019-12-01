package com.kodilla.travelagency.repository;

import com.kodilla.travelagency.domain.Trip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface TripRepository extends CrudRepository<Trip, Long> {

    @Override
    List<Trip> findAll();

    @Override
    Optional<Trip> findById(Long id);

    Optional<Trip> findByType(String type);

    Optional<Trip> findByDestination(String destination);
}
