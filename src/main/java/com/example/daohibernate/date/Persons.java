package com.example.daohibernate.date;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Persons", schema = "netology")
@Data
@Builder
public class Persons {
    @EmbeddedId
    private User user;
    @Column(length = 12, name = "phonenumber", nullable = false)
    private String phoneNumber;
    @Column(length = 50, name = "city", nullable = false)
    private String city;
}
