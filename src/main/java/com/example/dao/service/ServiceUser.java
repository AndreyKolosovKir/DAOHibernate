package com.example.dao.service;

import com.example.dao.date.Persons;
import com.example.dao.repository.RepPerson;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

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
