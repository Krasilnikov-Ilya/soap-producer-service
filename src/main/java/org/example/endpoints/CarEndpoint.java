package org.example.endpoints;

import io.spring.guides.gs_producing_web_service.AddCarRequest;
import io.spring.guides.gs_producing_web_service.Car;
import io.spring.guides.gs_producing_web_service.GetCarRequest;
import io.spring.guides.gs_producing_web_service.GetCarResponse;
import org.example.converters.DtoMapper;
import org.example.dbrecords.CarRecord;
import org.example.dbrecords.EngineTypeRecord;
import org.example.repositories.CarRepository;
import org.example.repositories.EngineTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.math.BigDecimal;
import java.util.Objects;

@Endpoint
public class CarEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    private final CarRepository carRepository;

    private final EngineTypeRepository engineTypeRepository;

    @Autowired
    public CarEndpoint(CarRepository carRepository, EngineTypeRepository engineTypeRepository) {
        this.carRepository = carRepository;
        this.engineTypeRepository = engineTypeRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCarRequest")
    @ResponsePayload
    public GetCarResponse getCar(@RequestPayload GetCarRequest request) {
        GetCarResponse response = new GetCarResponse();
        response.setCar(DtoMapper.fromDbRecord(Objects.requireNonNull(carRepository.findById(request.getId()).orElse(null))));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addCarRequest")
    @ResponsePayload
    public GetCarResponse addCar(@RequestPayload AddCarRequest request) {
        Car entity = request.getCar();
        EngineTypeRecord selectedEngineType = engineTypeRepository.findByTypeName(request.getCar().getEngineType().value())
                .stream().findAny().orElse(null);

        CarRecord record = new CarRecord().setEngineType(selectedEngineType)
                .setMark(entity.getMark())
                .setModel(entity.getModel())
                .setPrice(BigDecimal.valueOf(entity.getPrice()));

        Long id = carRepository.saveAndFlush(record).getId();

        GetCarResponse response = new GetCarResponse();
        response.setCar(DtoMapper.fromDbRecord(Objects.requireNonNull(carRepository.findById(id).orElse(null))));
        return response;
    }
}
