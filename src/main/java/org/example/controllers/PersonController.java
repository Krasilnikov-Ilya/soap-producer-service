package org.example.controllers;

import lombok.RequiredArgsConstructor;
import org.example.converters.RestMapper;
import org.example.repositories.PersonRepository;
import org.example.restDto.PersonDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST-контроллер, работающий с людьми
 */
@CrossOrigin
@RestController
@RequiredArgsConstructor
public class PersonController {

    private final PersonRepository personRepository;

    @GetMapping(value = "/user/{userId}")
    public ResponseEntity<PersonDto> getUser(@PathVariable Long userId) {
        PersonDto personDto = personRepository.findById(userId)
                .map(RestMapper::fromDbRecord).orElse(null);
        if (personDto == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(personDto, HttpStatus.OK);
    }

    @GetMapping(value = "/get")
    public ResponseEntity<PersonDto> getUser() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
