package by.gorbov.space.controller;

import by.gorbov.space.entity.Planet;
import by.gorbov.space.service.PlanetService;
import by.gorbov.space.service.dto.PlanetDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planets")
@RequiredArgsConstructor
public class PlanetController {

    private final PlanetService planetService;

    @PostMapping()
    public PlanetDto createPlanet(@RequestBody PlanetDto planetDto) {
        return planetService.createPlanet(planetDto);
    }

    @GetMapping
    public List<PlanetDto> getPlanets() {
        return planetService.getPlanets();
    }

    @PostMapping("/change")
    public List<PlanetDto> naturalChangePopulation(){
        return planetService.naturalChangePopulation();
    }

    @PostMapping("/migration/{fromId}/{toId}")
    public List<PlanetDto> migrationPopulation(@PathVariable Long fromId,
                                      @PathVariable Long toId) {
        return planetService.migrationPopulation(fromId,toId);
    }



}
