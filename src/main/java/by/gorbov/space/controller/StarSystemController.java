package by.gorbov.space.controller;


import by.gorbov.space.entity.StarSystem;
import by.gorbov.space.service.StarSystemService;
import by.gorbov.space.service.dto.StarSystemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/starSystems")
@RequiredArgsConstructor
public class StarSystemController {

    private final StarSystemService starSystemService;

    @PostMapping
    void postStarSystems(@RequestBody List<StarSystemDto> starSystems){
        starSystemService.createStarSystems(starSystems);
    }

    @GetMapping
    List<StarSystemDto> getStarSystems(){
        return starSystemService.getStarSystems();
    }


}
