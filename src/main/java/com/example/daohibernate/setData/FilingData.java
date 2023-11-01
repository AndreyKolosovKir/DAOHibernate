package com.example.daohibernate.setData;

import com.example.daohibernate.date.Persons;
import com.example.daohibernate.date.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class FilingData implements CommandLineRunner {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        Persons viktor = Persons.builder().user(User.builder()
                        .name("Viktor")
                        .surname("Perminov")
                        .age("25")
                        .build())
                .phoneNumber("89658567485")
                .city("Moscow")
                .build();

        Persons natalia = Persons.builder().user(User.builder()
                        .name("Natalia")
                        .surname("Trifonova")
                        .age("27")
                        .build())
                .phoneNumber("89658567485")
                .city("Kirov")
                .build();

        Persons anton = Persons.builder().user(User.builder()
                        .name("Anton")
                        .surname("Vachevske")
                        .age("28")
                        .build())
                .phoneNumber("89658567485")
                .city("Vladivostok")
                .build();

        Persons andrey = Persons.builder().user(User.builder()
                        .name("Andrey")
                        .surname("Suvorov")
                        .age("30")
                        .build())
                .phoneNumber("89658567485")
                .city("Moscow")
                .build();
        entityManager.persist(viktor);
        entityManager.persist(natalia);
        entityManager.persist(andrey);
        entityManager.persist(anton);
    }
}
