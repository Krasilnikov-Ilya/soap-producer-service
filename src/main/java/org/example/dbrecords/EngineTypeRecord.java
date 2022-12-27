package org.example.dbrecords;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "ENGINE_TYPE")
@RequiredArgsConstructor
@Accessors(chain = true)
@Getter
@Setter
@ToString
public class EngineTypeRecord {

    @Id
    @Column(name = "ID")
    @GenericGenerator(name = "incrementGenerator", strategy = "increment")
    @GeneratedValue(generator = "incrementGenerator")
    private Long id;

    @Column(name = "TYPE_NAME")
    private String typeName;
}
