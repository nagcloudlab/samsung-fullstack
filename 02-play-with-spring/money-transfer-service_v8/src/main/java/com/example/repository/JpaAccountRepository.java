package com.example.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.example.entity.Account;

@Component("jpaAccountRepository")
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
