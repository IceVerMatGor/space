package by.gorbov.space.service;

import by.gorbov.space.entity.Planet;
import by.gorbov.space.service.dto.PlanetDto;

import java.util.List;

public interface PlanetService {

    List<PlanetDto> getPlanets();

    List<PlanetDto> naturalChangePopulation();

    List<PlanetDto> migrationPopulation(Long fromId, Long toId);

    PlanetDto createPlanet(PlanetDto planetDto);
}
