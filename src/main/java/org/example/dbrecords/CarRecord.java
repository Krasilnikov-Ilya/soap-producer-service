package org.example.dbrecords;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "CAR")
@RequiredArgsConstructor
@Accessors(chain = true)
@Getter
@Setter
@ToString
public class CarRecord {

    @Id
    @Column(name = "ID")
    @GenericGenerator(name = "incrementGenerator", strategy = "increment")
    @GeneratedValue(generator = "incrementGenerator")
    private Long id;

    @OneToOne(targetEntity = EngineTypeRecord.class, cascade = CascadeType.MERGE)
    @JoinColumn(name = "ENGINE_TYPE_ID", referencedColumnName = "ID")
    private EngineTypeRecord engineType;

    @OneToOne(targetEntity = PersonRecord.class, cascade = CascadeType.MERGE)
    @JoinColumn(name = "PERSON_ID", referencedColumnName = "ID")
    private PersonRecord person;

    @Column(name = "MARK")
    private String mark;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "PRICE")
    private BigDecimal price;
}

