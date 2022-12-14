package org.example.jpa;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Отображение таблицы "Человек"
 */
@Entity
@Table(name = "PERSON")
@RequiredArgsConstructor
@Accessors(chain = true)
@Getter
@Setter

public class PersonRecord {
    /**
     * Идентификатор человека
     */
    @Id
    @Column(name = "ID")
    @GenericGenerator(name = "incrementGenerator", strategy = "increment")
    @GeneratedValue(generator = "incrementGenerator")
    private Long id;

    /**
     * Имя
     */
    @Column(name = "FIRST_NAME")
    private String firstName;

    /**
     * Фамилия
     */
    @Column(name = "LAST_NAME")
    private String lastName;

    /**
     * Возраст
     */
    @Column(name = "AGE")
    private Integer age;

    /**
     * Пол
     */
    @Column(name = "SEX")
    private Boolean sex;

    /**
     * Деньги
     */
    @Column(name = "MONEY")
    private BigDecimal money;

}
