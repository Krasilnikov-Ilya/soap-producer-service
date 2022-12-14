package org.example.converters;
import io.spring.guides.gs_producing_web_service.Person;
import org.example.jpa.PersonRecord;


public class RecordMapper {

    public static Person fromDBrecord(PersonRecord record) {
        Person person = new Person();
        person.setId(record.getId());
        person.setFirstName(record.getFirstName());
        person.setSecondName(record.getLastName());
        person.setAge(record.getAge());
        person.setMoney(record.getMoney().doubleValue());
        return person;
    }
}
