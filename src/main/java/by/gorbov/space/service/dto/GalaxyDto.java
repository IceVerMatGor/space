package by.gorbov.space.service.dto;

import by.gorbov.space.entity.GalaxyType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GalaxyDto {

    private Long id;

    private String name;

    private GalaxyType galaxyType;

    private List<StarSystemDto> starSystemsDto;

    private String imagePath;

}
