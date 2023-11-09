package com.example.daohibernate.controller;

import com.example.daohibernate.date.Persons;
import com.example.daohibernate.service.ServiceUser;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Optional;

@RestController
public class ControllerUserDate {

    private final ServiceUser serviceUser;

    public ControllerUserDate(ServiceUser serviceUser) {
        this.serviceUser = serviceUser;
    }

    //Данный запрос поиска по городу оставил без изменений (так же в репозитории)
    @RolesAllowed({"ROLE_WRITE"})
    @GetMapping("/persons/by-city")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Persons> getMapping(@RequestParam("city") String city) {
        return serviceUser.getPersonsByCity(city);
    }

    //Добавление нового пользователя
    @RolesAllowed({"ROLE_WRITE"})
    @PostMapping("/persons/new_person")
    @ResponseStatus(code = HttpStatus.OK)
    public Object savePerson(@RequestBody Persons person) {
        return serviceUser.savePersons(person);
    }

    //Поиск пользователей по id
    @Secured({"ROLE_READ"})
    @GetMapping("/persons/by-id")
    @ResponseStatus(code = HttpStatus.OK)
    public Object findById(@RequestParam("id") int id) {
        return serviceUser.findById(id);
    }

    //Вывод всех пользователей
    //Принимает в качестве параметра имя пользователя
    @PreAuthorize("authentication.principal.username == 'Vadim'")
    @GetMapping("/persons")
    @ResponseStatus(code = HttpStatus.OK)
    public Object findAll() {
        return serviceUser.findAll();
    }

    //Обновление номера телефона по id
    @RolesAllowed({"ROLE_WRITE"})
    @PostMapping("/persons/update-phone-by-id")
    @ResponseStatus(code = HttpStatus.OK)
    public Object updatePhoneNumber(@RequestBody Persons persons) {
        int id = persons.getId();
        String phoneNumber = persons.getPhoneNumber();
        return serviceUser.updatePhoneNumber(id, phoneNumber);
    }

    //Поиск по году
    @RolesAllowed({"ROLE_WRITE"})
    @GetMapping("/persons/by-age-less")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Persons> getPersonsByAgeLess(@RequestParam("age") Integer age) {
        return serviceUser.getPersonsByAgeLess(age);
    }

    //Поиск по имени и фамилии
    @Secured({"ROLE_READ"})
    @GetMapping("/persons/by-name-and-surname")
    @ResponseStatus(code = HttpStatus.OK)
    public Optional<Persons> getPersonsByNameAndSurname(
            @RequestParam("name") String name,
            @RequestParam("surname") String surname
    ) {
        return serviceUser.getPersonsByNameAndSurname(name, surname);
    }

    //Удаление по id
    @PostAuthorize("hasAnyRole('WRITE') or hasAnyRole('DELETE')")
    @DeleteMapping("/persons/delete-by-id")
    @ResponseStatus(code = HttpStatus.OK)
    public Object delete(@RequestParam("id") int id) {
        return serviceUser.deleteById(id);
    }
}
