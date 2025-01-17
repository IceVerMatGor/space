package by.gorbov.space.service.dto;

import by.gorbov.space.entity.Planet;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StarSystemDto {

    private Long id;

    private String name;

    private Long mass;

    private Long speed;

    private List<StarDto> starDtoList;

    private List<PlanetDto> planetDtoList;

    private String imagePath;


    private Long galaxyId;


}
