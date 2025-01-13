package by.gorbov.space.service.mapper;

import by.gorbov.space.entity.Galaxy;
import by.gorbov.space.entity.Planet;
import by.gorbov.space.service.dto.GalaxyDto;
import by.gorbov.space.service.dto.PlanetDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlanetMapper {
    List<Planet> planetsDtoToPlanets(List<PlanetDto> planetDtos);

    List<PlanetDto> planetsToPlanetsDto(List<Planet> planets);

}
