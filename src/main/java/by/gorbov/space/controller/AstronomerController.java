package by.gorbov.space.controller;

import by.gorbov.space.entity.Astronomer;
import by.gorbov.space.service.AstronomerService;
import by.gorbov.space.service.dto.AddRole;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
public class AstronomerController {

    private final AstronomerService astronomerService;

    public AstronomerController(AstronomerService astronomerService) {
        this.astronomerService = astronomerService;
    }

    @GetMapping("/astronomers/{id}")
    public Astronomer getAstronomer(@PathVariable Long id) {
        return astronomerService.getAstronomer(id);
    }

    @PostMapping("/registration")
    public Astronomer postAstronomer(@RequestBody Astronomer astronomer) {
        astronomerService.createAstronomer(astronomer);
        return astronomer;
    }

    @PatchMapping("/astronomers/addAuthority")
    public void addAuthorityToAstronomer(@RequestBody AddRole addRole) {
        astronomerService.addAuthorityToAstronomer(addRole);
    }


}
