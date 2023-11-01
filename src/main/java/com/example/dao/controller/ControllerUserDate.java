package com.example.dao.controller;

import com.example.dao.date.Persons;
import com.example.dao.service.ServiceUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControllerUserDate {

    private final ServiceUser serviceUser;

    public ControllerUserDate(ServiceUser serviceUser) {
        this.serviceUser = serviceUser;
    }

    @GetMapping("/persons/by-city")
    public List<Persons> getMapping (@RequestParam("city") String city){
        return serviceUser.getPersonsByCity(city);
    }
}
