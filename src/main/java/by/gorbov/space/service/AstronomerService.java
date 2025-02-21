package by.gorbov.space.service;

import by.gorbov.space.entity.Astronomer;
import by.gorbov.space.service.dto.AddRole;
import by.gorbov.space.service.dto.Login;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;

public interface AstronomerService extends UserDetailsService {

    Astronomer createAstronomer(Astronomer astronomer);



    Astronomer getAstronomer(Long id);

    void addAuthorityToAstronomer(AddRole addRole);

}
