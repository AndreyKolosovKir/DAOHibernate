package com.example.daohibernate.date;

import lombok.*;

import javax.persistence.Embeddable;

@Embeddable
@Builder
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String name;
    private String surname;
    private int age;
}
