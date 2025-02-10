package by.gorbov.space.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "planet")
public class Planet extends AbstractEntity{




    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "star_system_id")
    private StarSystem starSystem;
}
