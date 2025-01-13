package by.gorbov.space.service.mapper;

import by.gorbov.space.entity.Galaxy;
import by.gorbov.space.service.dto.GalaxyDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GalaxyMapper {


    List<Galaxy> galaxiesDtoToGalaxies(List<GalaxyDto> galaxiesDto);

    @Mapping(target = "starSystems",source = "starSystemsDto")
    Galaxy galaxyDtoToGalaxy(GalaxyDto galaxyDto);





    List<GalaxyDto> galaxiesToGalaxiesDto(List<Galaxy> galaxies);

    @Mapping(target = "starSystemsDto", source = "starSystems")
    GalaxyDto galaxyToGalaxyDto(Galaxy galaxy);





}
