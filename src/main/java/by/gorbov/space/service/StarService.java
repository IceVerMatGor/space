package by.gorbov.space.service;


import by.gorbov.space.entity.Star;

import by.gorbov.space.service.dto.StarDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StarService {

    void createStars(List<StarDto> starDtos);

    List<StarDto> getAllStars();

    void updateStar(Star star);

    void deleteAllStarsByIds(List<Long> ids);

}
