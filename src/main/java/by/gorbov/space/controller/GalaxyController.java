package by.gorbov.space.controller;

import by.gorbov.space.entity.Galaxy;
import by.gorbov.space.repo.GalaxyRepository;
import by.gorbov.space.service.GalaxyService;
import by.gorbov.space.service.dto.StarDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class GalaxyController {

    private final GalaxyService galaxyService;

    private final GalaxyRepository galaxyRepository;

    public GalaxyController(GalaxyService galaxyService, GalaxyRepository galaxyRepository) {
        this.galaxyService = galaxyService;
        this.galaxyRepository = galaxyRepository;
    }


    @PostMapping
    void postGalaxies(@RequestBody List<Galaxy> galaxies){
        galaxyRepository.saveAll(galaxies);
    }

    @GetMapping
    String string(){
        galaxyService.to();
        return "ljnljsfnal";
    }


}
