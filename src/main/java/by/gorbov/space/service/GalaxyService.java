package by.gorbov.space.service;

import by.gorbov.space.entity.Galaxy;
import by.gorbov.space.service.dto.GalaxyDto;
import by.gorbov.space.service.mapper.GalaxyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GalaxyService {


    private final GalaxyMapper galaxyMapper;

    public void to(){
        List<Galaxy> galaxies = new ArrayList<>();
        Galaxy galaxy = new Galaxy();
        galaxies.add(galaxy);

        List<GalaxyDto> galaxyDtos = galaxyMapper.galaxiesToGalaxiesDto(galaxies);
        System.out.println("kk");
    }

}
