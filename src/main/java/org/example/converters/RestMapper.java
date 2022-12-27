package org.example.converters;

import org.example.jpa.PersonRecord;
import org.example.restDto.PersonDto;
import org.example.restDto.PersonSex;

public class RestMapper {
    public static PersonDto fromDbRecord(PersonRecord record) {
        PersonDto person = new PersonDto();
        person.setId(record.getId());
        person.setFirstName(record.getFirstName());
        person.setSecondName(record.getLastName());
        person.setAge(record.getAge());
        person.setSex(record.getSex() ? PersonSex.MALE : PersonSex.FEMALE);
        person.setMoney(record.getMoney());
        return person;
    }

    public static PersonRecord fromRestEntity(PersonDto person) {
        PersonRecord record = new PersonRecord();
        record.setId(person.getId());
        record.setFirstName(person.getFirstName());
        record.setLastName(person.getSecondName());
        record.setAge(person.getAge());
        record.setSex(person.getSex() == PersonSex.MALE);
        record.setMoney(person.getMoney());
        return record;
    }
}
