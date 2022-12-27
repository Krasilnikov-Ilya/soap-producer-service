package org.example.converters;

import io.spring.guides.gs_producing_web_service.Car;
import io.spring.guides.gs_producing_web_service.EngineType;
import io.spring.guides.gs_producing_web_service.Person;
import io.spring.guides.gs_producing_web_service.Sex;
import org.example.dbrecords.CarRecord;
import org.example.dbrecords.EngineTypeRecord;
import org.example.dbrecords.PersonRecord;

import java.math.BigDecimal;


public class DtoMapper {

    public static Person fromDbRecord(PersonRecord record) {
        Person person = new Person();
        person.setId(record.getId());
        person.setFirstName(record.getFirstName());
        person.setSecondName(record.getLastName());
        person.setAge(record.getAge());
        person.setSex(record.getSex() ? Sex.MALE : Sex.FEMALE);
        person.setMoney(record.getMoney().doubleValue());
        return person;
    }

    public static PersonRecord toDbRecord(Person person) {
        PersonRecord record = new PersonRecord();
        record.setId(person.getId());
        record.setFirstName(person.getFirstName());
        record.setLastName(person.getSecondName());
        record.setAge(person.getAge());
        record.setSex(person.getSex() == Sex.MALE);
        record.setMoney(BigDecimal.valueOf(person.getMoney()));
        return record;
    }

    public static EngineType fromDbRecord(EngineTypeRecord record) {
        if (record.getTypeName().equals("Gasoline")) return EngineType.GASOLINE;
        if (record.getTypeName().equals("Diesel")) return EngineType.DIESEL;
        if (record.getTypeName().equals("CNG")) return EngineType.CNG;
        if (record.getTypeName().equals("Hydrogenic")) return EngineType.HYDROGENIC;
        if (record.getTypeName().equals("Electric")) return EngineType.ELECTRIC;
        if (record.getTypeName().equals("PHEV")) return EngineType.PHEV;
        return null;
    }

    public static EngineTypeRecord toDbRecord(EngineType engineType) {
        return new EngineTypeRecord().setTypeName(engineType.value());
    }

    public static Car fromDbRecord(CarRecord record) {
        Car car = new Car();
        car.setId(record.getId());
        car.setMark(record.getMark());
        car.setModel(record.getModel());
        car.setEngineType(fromDbRecord(record.getEngineType()));
        car.setPrice(record.getPrice().doubleValue());
        return car;
    }

    public static CarRecord toDbRecord(Car car) {
        CarRecord record = new CarRecord();
        record.setId(car.getId());
        record.setMark(car.getMark());
        record.setModel(car.getModel());
        record.setEngineType(toDbRecord(car.getEngineType()));
        record.setPrice(BigDecimal.valueOf(car.getPrice()));
        return record;
    }
}
