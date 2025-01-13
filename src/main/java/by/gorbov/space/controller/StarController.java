package by.gorbov.space.controller;

import by.gorbov.space.service.StarService;
import by.gorbov.space.service.dto.StarDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stars")
public class StarController {

    private final StarService starService;

    public StarController(StarService starService) {
        this.starService = starService;
    }


    @PostMapping
    void postStars(@RequestBody List<StarDto> starDtos){
        starService.createStars(starDtos);
    }

    @GetMapping
    List<StarDto> getAllStars(){
        return starService.getAllStars();
    }




}
