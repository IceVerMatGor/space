package by.gorbov.space.service;

import by.gorbov.space.entity.Galaxy;
import by.gorbov.space.repo.GalaxyRepository;
import by.gorbov.space.service.dto.GalaxyDto;
import by.gorbov.space.service.mapper.AbstractMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class GalaxyAbstractServiceImpl
        extends AbstractService<
        Galaxy,
        GalaxyDto,
        GalaxyRepository,
        AbstractMapper<Galaxy,GalaxyDto>>{

    public GalaxyAbstractServiceImpl(
            GalaxyRepository repository,
            @Qualifier("galaxyMapperImpl") AbstractMapper<Galaxy, GalaxyDto> mapper) {
        super(repository, mapper);

    }

    public List<GalaxyDto> divide(GalaxyDto galaxyDto) {
        return null;
    }
}
