package com.kodilla.travelagency.repository;

import com.kodilla.travelagency.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Long> {

    @Override
    List<User> findAll();

    @Override
    User save(User user);

    @Override
    void delete(User user);

    @Override
    void deleteById(final Long id);


    Optional<User> findByLogin(String login);
}
