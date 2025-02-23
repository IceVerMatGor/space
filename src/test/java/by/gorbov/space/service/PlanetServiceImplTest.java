package by.gorbov.space.service;

import by.gorbov.space.entity.Planet;
import by.gorbov.space.repo.PlanetRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class PlanetServiceImplTest {

    private PlanetServiceImpl service;

    @Mock
    private PlanetRepository repo;

    @Test
    void createPlanet() {
       repo.save(new Planet());
    }

    @Test
    void getPlanets() {

    }

    @Test
    void naturalChangePopulation() {
    }





    @Test
    void migrationPopulation() {
        Planet planetFrom = new Planet();
        planetFrom.setId(1L);
        planetFrom.setPopulation(10);

        Planet planetTo = new Planet();
        planetTo.setId(2L);
        planetTo.setPopulation(0);

        service.migrationPopulation(1L, 2L);

        Assertions.assertEquals(5, planetTo.getPopulation());
        Assertions.assertEquals(5, planetFrom.getPopulation());
    }
}