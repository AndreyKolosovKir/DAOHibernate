package com.example.daohibernate.repository;

import com.example.daohibernate.date.Persons;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class RepUser {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<Persons> getPersonsByCity(String city) {
        return entityManager.createQuery(
                "select persons from Persons persons where persons.city = :city", Persons.class
                )
                .setParameter("city", city)
                .getResultList();
    }
}
