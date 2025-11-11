package com.example.rest_with_spring_boot_and_java_erudio.request.converters;

import com.example.rest_with_spring_boot_and_java_erudio.model.Person;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {
    private final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public Person findById(String id) {
        logger.info("Finding person with id " + id);

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Rui");
        person.setLastName("Ruiz");
        person.setAddress("Leiria");
        person.setGender("Male");
        return person;
    }
}
