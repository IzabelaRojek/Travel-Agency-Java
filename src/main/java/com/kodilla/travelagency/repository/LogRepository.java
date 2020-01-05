package com.kodilla.travelagency.repository;

import com.kodilla.travelagency.domain.Log;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface LogRepository extends CrudRepository<Log, Long> {

    @Override
    Log save(Log log);

    @Override
    List<Log> findAll();
}
