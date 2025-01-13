package by.gorbov.space.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor

@Table(name = "star_system")
public class StarSystem extends AbstractEntity{


    @OneToMany(mappedBy = "starSystem")
    private List<Star> stars;

    @OneToMany(mappedBy = "starSystem")
    private List<Planet> planets;

    @ManyToOne
    private Galaxy galaxy;

}
