package com.carlos.bank.data.repository;

import com.carlos.bank.data.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUserId(Long userId);

}
