package com.carlos.bank.data.repository;

import com.carlos.bank.data.entity.Transfer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface TransferRepository extends CrudRepository<Transfer, Long> {

    List<Transfer> findAll();

    List<Transfer> findByTransferDate(Date date);

    Transfer save(Transfer transfer);

}
