package com.carlos.bank.data.repository;

import com.carlos.bank.data.entity.Account;
import com.carlos.bank.data.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {


    Account findByAccountId(String accountId);

    List<Account> findAll();

    List<Account> findByUserId(String userId);


}
