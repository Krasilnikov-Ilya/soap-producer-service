package org.example.dbrecords;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "PERSON")
@RequiredArgsConstructor
@Accessors(chain = true)
@Getter
@Setter

public class PersonRecord {

    @Id
    @Column(name = "ID")
    @GenericGenerator(name = "incrementGenerator", strategy = "increment")
    @GeneratedValue(generator = "incrementGenerator")
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "SECOND_NAME")
    private String lastName;

    @Column(name = "AGE")
    private Integer age;

    @Column(name = "SEX")
    private Boolean sex;

    @Column(name = "MONEY")
    private BigDecimal money;

}
