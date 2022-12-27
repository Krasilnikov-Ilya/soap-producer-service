package org.example.endpoints;

import io.spring.guides.gs_producing_web_service.AddPersonRequest;
import io.spring.guides.gs_producing_web_service.GetPersonRequest;
import io.spring.guides.gs_producing_web_service.GetPersonResponse;
import org.example.converters.DtoMapper;
import org.example.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.Objects;

@Endpoint
public class PersonEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    private final PersonRepository personRepository;

    @Autowired
    public PersonEndpoint(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPersonRequest")
    @ResponsePayload
    public GetPersonResponse getUser(@RequestPayload GetPersonRequest request) {
        GetPersonResponse response = new GetPersonResponse();
        response.setPerson(DtoMapper.fromDbRecord(Objects.requireNonNull(personRepository.findById(request.getId()).orElse(null))));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addPersonRequest")
    @ResponsePayload
    public GetPersonResponse addUser(@RequestPayload AddPersonRequest request) {
        Long id = personRepository.saveAndFlush(DtoMapper.toDbRecord(request.getPerson())).getId();
        GetPersonResponse response = new GetPersonResponse();
        response.setPerson(DtoMapper.fromDbRecord(Objects.requireNonNull(personRepository.findById(id).orElse(null))));
        return response;
    }
}
