package com.example.dao.repository;

import com.example.dao.date.Persons;
import com.example.dao.date.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepUser {

    private final CrudRepository crudRepository;

    public RepUser(CrudRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

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

    @Transactional
    public Object savePersons(
//            String name,
//            String surname,
//            String age,
//            String phoneNumber,
//            String city
    ) {
        Persons veronika = Persons.builder()
                .user(
                        User.builder()
                                .name("Veronika")
                                .surname("Stepanova")
                                .age("55")
                                .build())
                .phoneNumber("89698587412")
                .city("Mehico")
                .build();
        crudRepository.save(veronika);
        return veronika;
    }

    @Transactional
    public Object findById(String name, String surname, String age){
        Object person = crudRepository.findOne()
    }
}
