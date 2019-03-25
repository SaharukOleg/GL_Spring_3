package study.basecamp.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class NumberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "number")
    private int number;

}
