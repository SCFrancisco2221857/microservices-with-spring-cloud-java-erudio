package com.example.rest_with_spring_boot_and_java_erudio.request.converters;

import com.example.rest_with_spring_boot_and_java_erudio.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    public List<Person> findAll() {
        List<Person> people = new ArrayList<Person>();
        for(int i = 0; i < 10; i++) {
            Person person = mockPerson(i);
            people.add(person);
        }
        return people;
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
}
