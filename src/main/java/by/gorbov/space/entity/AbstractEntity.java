package by.gorbov.space.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@MappedSuperclass
public class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected Long id;

    @Column(name = "name")
    protected String name;

    @Column(name = "mass")
    protected Long mass;

    @Column(name = "speed")
    protected Long speed;
}
