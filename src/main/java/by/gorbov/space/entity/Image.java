package by.gorbov.space.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Image {

    @Id
    private UUID id;

    private String pathToFile;

    private String originalFileName;

    private String contentType;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private Galaxy galaxy;


}
