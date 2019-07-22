package com.carlos.bank.data.repository;

import com.carlos.bank.data.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByUserId(String userId);

    List<User> findAll();

    User save(User user);

}
