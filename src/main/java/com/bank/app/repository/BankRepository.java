package com.bank.app.repository;


import com.bank.app.domain.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface BankRepository extends JpaRepository<Bank, Integer> {

    @Query(value = "select branch_code, branch_name from Branch where bank_id in (select bank_id from Bank where (bank_id =:bank_id))",
            nativeQuery = true)
    Collection branchDetails(@Param("bank_id") int bankId);


}
