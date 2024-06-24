package com.example.repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.entity.Account;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

// @Component("jpaAccountRepository")
@Repository("jpaAccountRepository")
public class JpaAccountRepository implements AccountRepository {

    @PersistenceContext // this will inject entity-manager from entity-manager-factory
    private EntityManager entityManager;

    @Override
    public Account loadAccount(String accountNumber) {
        return entityManager.find(Account.class, accountNumber);
    }

    @Override
    public void updateAccount(Account account) {
        entityManager.merge(account);
    }

}
