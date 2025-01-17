package by.gorbov.space.service;

import by.gorbov.space.entity.Galaxy;
import by.gorbov.space.repo.GalaxyRepository;
import by.gorbov.space.service.dto.GalaxyDto;
import by.gorbov.space.service.mapper.GalaxyMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@Service
public class GalaxyServiceImpl implements GalaxyService {

    private static final Logger log = LoggerFactory.getLogger(GalaxyServiceImpl.class);
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
            if (picture!=null) {
                path = "images/" + picture.getOriginalFilename();
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
    public byte[] getPicture(Long id) {
        Optional<Galaxy> galaxy = galaxyRepository.findById(id);
        if (galaxy.isPresent()) {
            String path = galaxy.get().getImagePath();
            try {
                return Files.readAllBytes(Path.of(path));
            } catch (IOException e) {
                log.error(e.getLocalizedMessage());
            }
        }
        return null;
    }

    @Override
    public List<GalaxyDto> getGalaxies() {

        List<Galaxy> galaxies = galaxyRepository.findAll();
        return galaxyMapper.galaxiesToGalaxiesDto(galaxies);

    }
}
