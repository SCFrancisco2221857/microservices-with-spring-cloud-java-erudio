package com.example.rest_with_spring_boot_and_java_erudio.services;

import com.example.rest_with_spring_boot_and_java_erudio.exception.ResourceNotFoundException;
import com.example.rest_with_spring_boot_and_java_erudio.model.Person;
import com.example.rest_with_spring_boot_and_java_erudio.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


@Service
public class PersonService {
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    PersonRepository repository;

    private Logger logger = LoggerFactory.getLogger(PersonService.class.getName());

    public Person findById(Long id) {
        logger.info("Finding person with id " + id);
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person with id not found"));
    }

    public List<Person> findAll() {
        logger.info("Finding all people");
        return repository.findAll();
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Rui" + i);
        person.setLastName("Ruiz"+ i);
        person.setAddress("Leiria" + i);
        person.setGender("Male" + i);
        return person;
    }

    public Person create(Person person) {
        logger.info("Creating person with id " + person.getId());
        return repository.save(person);
    }

    public Person update(Person person) {
        logger.info("Updating person with id " + person.getId());
        Person entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("Person with id not found"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(entity);
    }
    public void delete(Long id) {
        logger.info("Deleting person with id " + id);
        Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person with id not found"));
        repository.deleteById(id);
    }
}
