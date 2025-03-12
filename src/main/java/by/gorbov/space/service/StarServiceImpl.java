package by.gorbov.space.service;

import by.gorbov.space.entity.Star;
import by.gorbov.space.entity.StarSystem;
import by.gorbov.space.repo.StarRepository;
import by.gorbov.space.service.dto.StarDto;
import by.gorbov.space.service.mapper.StarMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class StarServiceImpl implements StarService {

    private final StarRepository starRepository;
    private final StarMapper starMapper;

    public StarServiceImpl(StarRepository starRepository, StarMapper starMapper) {
        this.starRepository = starRepository;
        this.starMapper = starMapper;
    }

    @Override
    public void createStars(List<StarDto> starDtos) {
        log.info("post stars");
        List<Star> stars = starMapper.starsDtoToStars(starDtos);

        log.info("Mapper ok");
        starRepository.saveAll(stars);
    }

    @Override
    public List<StarDto> getAllStars() {

        List<StarDto> starDtos;
        List<Star> stars;
        stars = starRepository.findAll();



        log.info("Repository find all ok");
        starDtos = starMapper.starsToStarsDto(stars);
        log.info("Mapper ok");
        return starDtos;
    }

    @Override
    public void updateStar(Star star) {

    }

    @Override
    public void deleteAllStarsByIds(List<Long> ids) {

    }
}
