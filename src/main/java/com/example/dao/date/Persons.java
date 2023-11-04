package com.example.dao.date;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Persons", schema = "netology")
public class Persons {
    @Id
    @GeneratedValue
    private int id;
    @Embedded
    private User user;
    @Column(name = "phonenumber")
    private String phoneNumber;
    private String city;
}
