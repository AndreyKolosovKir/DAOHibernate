package com.example.daohibernate.service;

import com.example.daohibernate.date.Persons;
import com.example.daohibernate.repository.RepPerson;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ServiceUser {

    private final RepPerson repPerson;

    public ServiceUser(RepPerson repPerson) {
        this.repPerson = repPerson;
    }

    public List<Persons> getPersonsByCity(String city) {
        return repPerson.getPersonsByCity(city);
    }

    public Object savePersons(Persons persons) {
        return repPerson.savePersons(persons);
    }

    public Object findById(int id) {
        return repPerson.findById(id);
    }

    public List<Persons> findAll() {
        return repPerson.findAll();
    }

    public Object updatePhoneNumber(int id, String phoneNumber) {
        return repPerson.updatePhoneNumber(id, phoneNumber);
    }

    public List<Persons> getPersonsByAgeLess(int age) {
        return repPerson.findAllByAge(age);
    }

    public Optional<Persons> getPersonsByNameAndSurname(String name, String surName) {
        return repPerson.findAllByNameAndSurname(name, surName);
    }

    public Object deleteById(int id) {
        return repPerson.deleteById(id);
    }
}
