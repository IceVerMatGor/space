package by.gorbov.space.service.dto;

import by.gorbov.space.entity.GalaxyType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GalaxyDto {

    @Min(1)
    private Long id;

    @NotBlank
    private String name;


    private GalaxyType galaxyType;

    private List<StarSystemDto> starSystemsDto;

    private String imagePath;

}
