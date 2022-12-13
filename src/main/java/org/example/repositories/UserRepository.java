package org.example.repositories;

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
        Person user = new Person();
        user.setId(1L);
        user.setFirstName("Michael");
        user.setSecondName("Lawson");
        user.setAge(42);
        user.setSex(Sex.MALE);
        user.setMoney(10000D);

        users.put(user.getId(), user);

        Person user2 = new Person();
        user.setId(2L);
        user.setFirstName("Lindsay");
        user.setSecondName("Ferguson");
        user.setAge(28);
        user.setSex(Sex.FEMALE);
        user.setMoney(15000D);

        users.put(user2.getId(), user);

        Person user3 = new Person();
        user.setId(3L);
        user.setFirstName("Byron");
        user.setSecondName("Fields");
        user.setAge(42);
        user.setSex(Sex.MALE);
        user.setMoney(20000D);

        users.put(user3.getId(), user);

        Person user4 = new Person();
        user.setId(4L);
        user.setFirstName("George");
        user.setSecondName("Edwards");
        user.setAge(30);
        user.setSex(Sex.MALE);
        user.setMoney(25000D);

        users.put(user4.getId(), user);
    }

    public Person findUser(Long id) {
        Assert.notNull(id, "Id must not be null");
        return users.get(id);
    }

}
