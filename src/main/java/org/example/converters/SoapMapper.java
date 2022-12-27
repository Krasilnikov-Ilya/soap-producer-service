package org.example.converters;

import io.spring.guides.gs_producing_web_service.Person;
import io.spring.guides.gs_producing_web_service.Sex;
import org.example.jpa.PersonRecord;

import java.math.BigDecimal;


public class SoapMapper {

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

    public static PersonRecord fromSoapEntity(Person person) {
        PersonRecord record = new PersonRecord();
        record.setId(person.getId());
        record.setFirstName(person.getFirstName());
        record.setLastName(person.getSecondName());
        record.setAge(person.getAge());
        record.setSex(person.getSex() == Sex.MALE);
        record.setMoney(BigDecimal.valueOf(person.getMoney()));
        return record;
    }
}
