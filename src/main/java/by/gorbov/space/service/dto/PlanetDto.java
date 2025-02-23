package by.gorbov.space.service.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlanetDto {

    @Min(1)
    private Long id;

    @NotBlank
    private String name;

    @Positive
    private Long mass;

    private Long speed;

    @NotBlank
    private String imagePath;

    private Integer population = 0;


}
