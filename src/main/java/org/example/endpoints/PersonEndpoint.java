package org.example.endpoints;

import io.spring.guides.gs_producing_web_service.AddUserRequest;
import io.spring.guides.gs_producing_web_service.GetUserRequest;
import io.spring.guides.gs_producing_web_service.GetUserResponse;
import org.example.converters.Mapper;
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

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getUser(@RequestPayload GetUserRequest request) {
        GetUserResponse response = new GetUserResponse();
        response.setUser(Mapper.fromDbRecord(Objects.requireNonNull(personRepository.findById(request.getId()).orElse(null))));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addUserRequest")
    @ResponsePayload
    public GetUserResponse addUser(@RequestPayload AddUserRequest request) {
        Long id = personRepository.saveAndFlush(Mapper.toDbRecord(request.getUser())).getId();
        GetUserResponse response = new GetUserResponse();
        response.setUser(Mapper.fromDbRecord(Objects.requireNonNull(personRepository.findById(id).orElse(null))));
        return response;
    }
}
