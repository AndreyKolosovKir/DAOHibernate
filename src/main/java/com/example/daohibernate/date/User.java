package com.example.daohibernate.date;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class User implements Serializable {
    @Column(length = 60, name = "name", nullable = false)
    private String name;
    @Column(length = 60, name = "surname", nullable = false)
    private String surname;
    @Column(length = 3, name = "age", nullable = false)
    private String age;
}
