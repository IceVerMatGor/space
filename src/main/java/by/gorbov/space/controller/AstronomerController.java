package by.gorbov.space.controller;

import by.gorbov.space.entity.Astronomer;
import by.gorbov.space.service.dto.Login;
import org.springframework.web.bind.annotation.*;

@RestController
public class AstronomerController {

    @GetMapping("/astronomers/{id}")
    public Astronomer getAstronomer(@PathVariable Long id) {
        return null;
    }

    @PostMapping("/registration")
    public Astronomer postAstronomer(@RequestBody Astronomer astronomer) {
        return astronomer;
    }

    @PostMapping("/login")
    public Astronomer login(@RequestBody Login login) {
        return null;
    }


    @PatchMapping("astronomers/addAuthority")
    public void addAuthorityToAstronomer(String username, String authority) {

    }






}
