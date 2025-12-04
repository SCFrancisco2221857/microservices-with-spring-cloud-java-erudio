package com.example.rest_with_spring_boot_and_java_erudio.controllers;

import com.example.rest_with_spring_boot_and_java_erudio.model.Person;
import com.example.rest_with_spring_boot_and_java_erudio.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findAll() {
        return personService.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById(@PathVariable("id") Long id) {
        return personService.findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person create(@RequestBody Person person) {
        return personService.create(person);
    }

    @PutMapping( consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person update(@RequestBody Person person) {
        return personService.update(person);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        personService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
