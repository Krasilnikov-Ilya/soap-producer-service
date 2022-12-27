package org.example.restDto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * Представление человека в API
 */
@Accessors(chain = true)
@Data
public class PersonDto {
    /**
     * Идентификатор человека
     */
    private Long id;

    /**
     * Имя
     */
    private String firstName;

    /**
     * Фамилия
     */
    private String secondName;

    /**
     * Возраст
     */
    private Integer age;

    /**
     * Пол
     */
    private PersonSex sex;

    /**
     * Деньги
     */
    private BigDecimal money;
}
