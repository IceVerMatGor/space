package by.gorbov.space.service;

import by.gorbov.space.entity.Astronomer;
import by.gorbov.space.repo.AstronomerRepository;
import by.gorbov.space.service.dto.AddRole;
import by.gorbov.space.service.dto.Login;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AstronomerServiceImpl implements AstronomerService{

    private final AstronomerRepository astronomerRepository;

    public AstronomerServiceImpl(AstronomerRepository astronomerRepository) {
        this.astronomerRepository = astronomerRepository;
    }

    @Override
    public Astronomer createAstronomer(Astronomer astronomer) {
        astronomerRepository.save(astronomer);
        return astronomer;
    }

    @Override
    public Astronomer login(Login login) {
        return null;
    }

    @Override
    public Astronomer getAstronomer(Long id) {
        Optional<Astronomer> astronomer = astronomerRepository.findById(id);
        return astronomer.orElse(null);

    }

    @Override
    public void addAuthorityToAstronomer(AddRole addRole) {
        astronomerRepository.addAuthorityToAstronomer(
                addRole.getAstronomerId(),
                addRole.getAuthorityId());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return astronomerRepository.findByUsername(username);
    }
}
