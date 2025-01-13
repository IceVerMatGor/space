package by.gorbov.space.service;

import by.gorbov.space.entity.StarSystem;
import by.gorbov.space.repo.StarSystemRepository;
import by.gorbov.space.service.dto.StarSystemDto;
import by.gorbov.space.service.mapper.StarSystemMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StarSystemServiceImpl implements StarSystemService {

    private final StarSystemRepository starSystemRepository;
    private final StarSystemMapper starSystemMapper;

    @Override
    public void createStarSystems(List<StarSystemDto> starSystemDtos) {

        List<StarSystem> starSystems = starSystemMapper
                .starSystemDtosToStarSystems(starSystemDtos);


        starSystemRepository.saveAll(starSystems);
    }

    @Override
    public List<StarSystemDto> getStarSystems() {
        List<StarSystem> starSystems = starSystemRepository.findAll();
        List<StarSystemDto> starSystemDtos;
        starSystemDtos = starSystemMapper
                .starSystemsToStarSystemDtos(starSystems);
        return starSystemDtos;
    }

    @Override
    public void updateStarSystem(StarSystem starSystem) {

    }

    @Override
    public void deleteAllStarSystemsByIds(List<Long> ids) {

    }
}
