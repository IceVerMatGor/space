package by.gorbov.space.service;

import by.gorbov.space.entity.Star;
import by.gorbov.space.entity.StarSystem;
import by.gorbov.space.service.dto.StarSystemDto;

import java.util.List;

public interface StarSystemService {

    void createStarSystems(List<StarSystemDto> starSystemDtos);

    List<StarSystemDto> getStarSystems();

    void updateStarSystem(StarSystem starSystem);

    void deleteAllStarSystemsByIds(List<Long> ids);

}
