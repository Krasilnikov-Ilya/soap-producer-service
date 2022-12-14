package org.example.endpoints;

import io.spring.guides.gs_producing_web_service.GetUserRequest;
import io.spring.guides.gs_producing_web_service.GetUserResponse;
import org.example.converters.RecordMapper;
import org.example.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UserEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    private final PersonRepository personRepository;

    @Autowired
    public UserEndpoint(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getUser(@RequestPayload GetUserRequest request) {
        GetUserResponse response = new GetUserResponse();
        response.setUser(RecordMapper.fromDBrecord(personRepository.findById(request.getId()).orElse(null)));
        return response;
    }
}
