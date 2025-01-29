package by.gorbov.space.service;

import by.gorbov.space.entity.Galaxy;
import by.gorbov.space.repo.GalaxyRepository;
import by.gorbov.space.service.dto.GalaxyDto;
import by.gorbov.space.service.mapper.GalaxyMapper;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class GalaxyServiceImpl implements GalaxyService {

    @Value("${directory}")
    private String directory;

    private final GalaxyMapper galaxyMapper;
    private final GalaxyRepository galaxyRepository;

    public GalaxyServiceImpl(GalaxyMapper galaxyMapper, GalaxyRepository galaxyRepository) {
        this.galaxyMapper = galaxyMapper;
        this.galaxyRepository = galaxyRepository;
    }

    @Override
    public void uploadPicture(MultipartFile picture, GalaxyDto galaxyDto) {

        try {
            String path = "";
            if (picture != null) {
                path = directory + UUID.nameUUIDFromBytes(picture.getBytes());
                picture.transferTo(Path.of(path));
            }
            galaxyDto.setImagePath(path);
            Galaxy galaxy = galaxyMapper.galaxyDtoToGalaxy(galaxyDto);
            galaxyRepository.save(galaxy);
        } catch (IOException e) {
            log.error(e.getLocalizedMessage());
        }

    }

    @Override
    public Resource getPicture(Long id) {
        Galaxy galaxy = galaxyRepository.findById(id).orElseThrow(RuntimeException::new);
        String path = galaxy.getImagePath();
        return new FileSystemResource(Path.of(path));
    }

    @Override
    public List<GalaxyDto> getGalaxies() {

        List<Galaxy> galaxies = galaxyRepository.findAll();
        return galaxyMapper.galaxiesToGalaxiesDto(galaxies);

    }
}
