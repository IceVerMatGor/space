package by.gorbov.space.service;

import by.gorbov.space.entity.Planet;
import by.gorbov.space.repo.PlanetRepository;
import by.gorbov.space.service.dto.PlanetDto;
import by.gorbov.space.service.mapper.PlanetMapper;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.databind.ser.std.JsonValueSerializer;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class PlanetServiceImpl implements PlanetService {

    private final PlanetRepository planetRepository;
    private final PlanetMapper planetMapper;
    private final RedisTemplate<String, Object> redisTemplate;


    @Override
    @Transactional
    public PlanetDto createPlanet(PlanetDto planetDto) {
        Planet planet = planetMapper.planetDtoToPlanet(planetDto);
        Planet planetToSave = planetRepository.save(planet);
        redisTemplate.opsForValue().set(planetToSave.getId().toString(),
                planetDto
        );
        return planetMapper.planetToPlanetDto(planetToSave);
    }

    @Override
    @Transactional
    public List<PlanetDto> getPlanets() {
        List<Planet> planets = planetRepository.findAll();

        PlanetDto planetDto = (PlanetDto) redisTemplate.opsForValue().get("11");

        List<PlanetDto> planetDtoList = planetMapper.planetsToPlanetsDto(planets);
        planetDtoList.add(planetDto);
        return planetDtoList;
    }

    @Override
    @Transactional
    public List<PlanetDto> naturalChangePopulation() {

        Random random = new Random();
        List<Planet> planets = planetRepository.findAll();
        planets.forEach(planet -> {
                    boolean god = random.nextBoolean();
                    if (god){
                        planet.setPopulation((int) (planet.getPopulation() * 1.5));
                    }else {
                        planet.setPopulation((int) (planet.getPopulation() / 1.5));
                    }
        });
        planetRepository.saveAll(planets);
        return planetMapper.planetsToPlanetsDto(planets);
    }

    @Override
    @Transactional(rollbackFor = NullPointerException.class)
    public List<PlanetDto> migrationPopulation(Long fromId, Long toId) {

        Integer migration = 0;

        Optional<Planet> OptionalPlanet = planetRepository.findById(fromId);
        Planet planet = OptionalPlanet.get();

        migration = planet.getPopulation()/2;
        planet.setPopulation(planet.getPopulation() - migration);


        Optional<Planet> OptionalPlanetTo = planetRepository.findById(toId);
        Planet planetTo = OptionalPlanetTo.get();
        planetTo.setPopulation(planetTo.getPopulation() + migration);

        List<Planet> planets = new ArrayList<>();
        planets.add(planet);
        planets.add(planetTo);

        planetRepository.saveAll(planets);
        return planetMapper.planetsToPlanetsDto(planets);
    }


}
