package by.gorbov.space.service;

import by.gorbov.space.entity.Astronomer;
import by.gorbov.space.repo.AstronomerRepository;
import by.gorbov.space.service.dto.AddRole;
import by.gorbov.space.service.dto.Login;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Optional;

@Service
public class AstronomerServiceImpl implements AstronomerService{

    private final AstronomerRepository astronomerRepository;

    public AstronomerServiceImpl(AstronomerRepository astronomerRepository) {
        this.astronomerRepository = astronomerRepository;
    }

    @Override
    @Transactional(rollbackFor = SQLException.class,
            isolation = Isolation.READ_COMMITTED)
    public Astronomer createAstronomer(Astronomer astronomer) {
        astronomerRepository.save(astronomer);
        return astronomer;
    }

    @Override
    @Transactional(rollbackFor = SQLException.class)
    public Astronomer login(Login login) {
        return null;
    }

    @Override
    @Transactional(rollbackFor = SQLException.class)
    public Astronomer getAstronomer(Long id) {
        Optional<Astronomer> astronomer = astronomerRepository.findById(id);
        return astronomer.orElse(null);

    }

    @Override
    @Transactional(rollbackFor = SQLException.class)
    public void addAuthorityToAstronomer(AddRole addRole) {
        astronomerRepository.addAuthorityToAstronomer(
                addRole.getAstronomerId(),
                addRole.getAuthorityId());
    }

    @Override
    @Transactional(rollbackFor = SQLException.class)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return astronomerRepository.findByUsername(username);
    }
}
