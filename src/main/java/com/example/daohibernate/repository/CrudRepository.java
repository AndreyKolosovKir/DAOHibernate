package com.example.daohibernate.repository;

import com.example.daohibernate.date.Persons;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CrudRepository extends JpaRepository<Persons, Integer> {
    List<Persons> findPersonsByUserAgeLessThanOrderByUserAge(int age);

    Optional<Persons> findPersonsByUserNameAndUserSurname(String name, String surname);
}
