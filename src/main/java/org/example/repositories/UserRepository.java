package org.example.repositories;

import io.spring.guides.gs_producing_web_service.Country;
import io.spring.guides.gs_producing_web_service.Person;
import io.spring.guides.gs_producing_web_service.Sex;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class UserRepository {
    private static final Map<Long, Person> users = new HashMap<>();

    @PostConstruct
    public void initData() {
        Person user1 = new Person();
        user1.setId(1L);
        user1.setFirstName("Michael");
        user1.setSecondName("Lawson");
        user1.setAge(42);
        user1.setSex(Sex.MALE);
        user1.setMoney(10000D);

        users.put(user1.getId(), user1);

        Person user2 = new Person();
        user2.setId(2L);
        user2.setFirstName("Lindsay");
        user2.setSecondName("Ferguson");
        user2.setAge(28);
        user2.setSex(Sex.FEMALE);
        user2.setMoney(15000D);

        users.put(user2.getId(), user2);

        Person user3 = new Person();
        user3.setId(3L);
        user3.setFirstName("Byron");
        user3.setSecondName("Fields");
        user3.setAge(42);
        user3.setSex(Sex.MALE);
        user3.setMoney(20000D);

        users.put(user3.getId(), user3);

        Person user4 = new Person();
        user4.setId(4L);
        user4.setFirstName("George");
        user4.setSecondName("Edwards");
        user4.setAge(30);
        user4.setSex(Sex.MALE);
        user4.setMoney(25000D);

        users.put(user4.getId(), user4);
    }

    public Person findUser(Long id) {
        Assert.notNull(id, "Id must not be null");
        return users.get(id);
    }
}
