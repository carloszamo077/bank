package com.carlos.bank.data.repository;

import com.carlos.bank.data.entity.Card;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends CrudRepository<Card, Long> {

    List<Card> findByCardId(String accountId);

    List<Card> findAll();

}
