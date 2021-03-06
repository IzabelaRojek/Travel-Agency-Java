package com.kodilla.travelagency.repository;

import com.kodilla.travelagency.domain.Complaint;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ComplaintRepository extends CrudRepository<Complaint, Long> {
    @Override
    Complaint save(Complaint complaint);

    @Override
    List<Complaint> findAll();

}
