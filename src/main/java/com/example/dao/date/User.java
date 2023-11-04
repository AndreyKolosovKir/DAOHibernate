package com.example.dao.date;

import jakarta.persistence.Embeddable;
import lombok.*;

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
