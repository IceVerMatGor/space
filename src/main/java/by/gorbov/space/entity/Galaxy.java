package by.gorbov.space.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "galaxy")
public class Galaxy extends AbstractEntity{



    @OneToMany(mappedBy = "galaxy")
    private List<StarSystem> starSystems;

    @Column(name = "galaxy_type")
     private GalaxyType galaxyType;
}
