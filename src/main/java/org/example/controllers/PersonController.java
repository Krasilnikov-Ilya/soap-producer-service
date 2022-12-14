package org.example.controllers;

import io.spring.guides.gs_producing_web_service.Person;
import lombok.RequiredArgsConstructor;
import org.example.converters.DtoMapper;
import org.example.repositories.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * REST-контроллер, работающий с людьми
 */
@CrossOrigin
@RestController
@RequiredArgsConstructor
public class PersonController {

    private final PersonRepository personRepository;

    @GetMapping(value = "/user/{personId}")
    public ResponseEntity<Person> getPerson(@PathVariable Long personId) {
        Person person = personRepository.findById(personId)
                .map(DtoMapper::fromDbRecord).orElse(null);
        if (person == null) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @GetMapping(value = "/users")
    public ResponseEntity<List<Person>> getPerson() {
        List<Person> persons = personRepository.findAll()
                .stream()
                .map(DtoMapper::fromDbRecord)
                .collect(Collectors.toList());
        if (persons.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }
}
