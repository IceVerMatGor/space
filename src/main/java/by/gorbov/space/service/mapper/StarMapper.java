package by.gorbov.space.service.mapper;

import by.gorbov.space.entity.Star;
import by.gorbov.space.entity.StarSystem;
import by.gorbov.space.service.dto.StarDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface StarMapper {

    List<StarDto> starsToStarsDto(List<Star> stars);

    List<Star> starsDtoToStars(List<StarDto> starsDto);
}
