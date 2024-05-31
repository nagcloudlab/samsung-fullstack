package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

    // // method DSL
    // Account findByAccountHolderName(String holderName); // select * from accounts
    // where holder_name = ?

    // // or

    // @Query("select a from Account a where a.accountHolderName = :holderName") //
    // JPQL
    // Account foo(@Param("holderName") String holderName);

}