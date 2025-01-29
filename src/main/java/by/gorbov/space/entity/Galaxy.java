package by.gorbov.space.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "galaxy")
public class Galaxy extends AbstractEntity{



    @OneToMany(mappedBy = "galaxy")
    private List<StarSystem> starSystems;

    @Column(name = "galaxy_type")
     private GalaxyType galaxyType;



}
