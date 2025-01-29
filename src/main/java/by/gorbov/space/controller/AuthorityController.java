package by.gorbov.space.controller;


import by.gorbov.space.entity.Authority;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authorities")
public class AuthorityController {

    @PostMapping
    public void postAuthority(@RequestBody Authority authority) {

    }

    @GetMapping
    public List<Authority> getAuthority() {
        return null;
    }




}
