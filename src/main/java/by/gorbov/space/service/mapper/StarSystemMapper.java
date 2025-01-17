package by.gorbov.space.service.mapper;


import by.gorbov.space.entity.Galaxy;
import by.gorbov.space.entity.StarSystem;
import by.gorbov.space.service.dto.StarSystemDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {StarMapper.class, PlanetMapper.class})
public interface StarSystemMapper {

    List<StarSystem> starSystemDtosToStarSystems(List<StarSystemDto> starSystemDtos);

    @Mapping(target = "stars",source = "starDtoList")
    @Mapping(target = "planets",source = "planetDtoList")
    @Mapping(target = "galaxy",source = "galaxyId")
    StarSystem starSystemDtoToStarSystem(StarSystemDto starSystemDto);

    default Long galaxyToGalaxyId(Galaxy galaxy){
        return galaxy.getId();
    }


    List<StarSystemDto> starSystemsToStarSystemDtos(List<StarSystem> starSystems);

    @Mapping(target = "starDtoList",source = "stars")
    @Mapping(target = "planetDtoList",source = "planets")
    @Mapping(target = "galaxyId",source = "galaxy")
    StarSystemDto starSystemToStarSystemDto(StarSystem starSystem);

    default Galaxy galaxyIdToGalaxy(Long galaxyId){
        Galaxy galaxy = new Galaxy();
        galaxy.setId(galaxyId);
        return galaxy;
    }



}
