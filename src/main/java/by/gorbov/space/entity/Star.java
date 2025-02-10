package by.gorbov.space.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "star")
public class Star extends AbstractEntity{

    @ManyToOne(fetch = FetchType.LAZY)
    private StarSystem starSystem;

}
