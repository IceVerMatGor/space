package by.gorbov.space.service;

import by.gorbov.space.entity.Astronomer;
import by.gorbov.space.entity.Authority;
import by.gorbov.space.repo.AstronomerRepository;
import by.gorbov.space.service.dto.AddRole;
import by.gorbov.space.service.dto.Login;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AstronomerServiceImpl implements AstronomerService{

    private final AstronomerRepository astronomerRepository;
    private final PasswordEncoder passwordEncoder;



    @Override
    @Transactional(rollbackFor = SQLException.class,
            isolation = Isolation.READ_COMMITTED)
    public Astronomer createAstronomer(Astronomer astronomer) {
        astronomer.setPassword(passwordEncoder.encode(astronomer.getPassword()));
        astronomerRepository.save(astronomer);
        return astronomer;
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
