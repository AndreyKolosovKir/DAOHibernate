package com.example.dao.service;

import com.example.dao.date.Persons;
import com.example.dao.repository.RepUser;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ServiceUser {

    private final RepUser repUser;

    public ServiceUser(RepUser repUser) {
        this.repUser = repUser;
    }

    public List<Persons> getPersonsByCity (String city){
       return repUser.getPersonsByCity(city);
    }
}
