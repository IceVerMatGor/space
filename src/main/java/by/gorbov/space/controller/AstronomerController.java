package by.gorbov.space.controller;

import by.gorbov.space.entity.Astronomer;
import by.gorbov.space.service.AstronomerService;
import by.gorbov.space.service.dto.AddRole;
import by.gorbov.space.service.dto.Login;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.web.bind.annotation.*;

@RestController
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

    @PostMapping("/login")
    public Astronomer login(@RequestBody Login login) {
        return astronomerService.login(login);
    }


    @PatchMapping("/astronomers/addAuthority")
    public void addAuthorityToAstronomer(@RequestBody AddRole addRole) {
        astronomerService.addAuthorityToAstronomer(addRole);
    }


}
