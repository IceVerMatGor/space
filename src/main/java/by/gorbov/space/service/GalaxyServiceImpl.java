package by.gorbov.space.service;

import by.gorbov.space.entity.Galaxy;
import by.gorbov.space.entity.Image;
import by.gorbov.space.repo.GalaxyRepository;
import by.gorbov.space.repo.ImageRepository;
import by.gorbov.space.service.dto.GalaxyDto;
import by.gorbov.space.service.mapper.GalaxyMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import java.nio.file.Path;

import java.sql.SQLException;
import java.util.List;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class GalaxyServiceImpl implements GalaxyService {


    @Value("${directory}")
    private String directory;


    private final ImageRepository imageRepository;
    private final GalaxyMapper galaxyMapper;
    private final GalaxyRepository galaxyRepository;



    @Override
    @Transactional(rollbackFor = SQLException.class, isolation = Isolation.READ_COMMITTED)
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

    @Override
    @Transactional(
            rollbackFor = {SQLException.class, IOException.class},
            isolation = Isolation.READ_COMMITTED)
    public void putPicture(MultipartFile picture, Long id) throws IOException {

        Image image = new Image();
        image.setId(UUID.nameUUIDFromBytes(picture.getBytes()));
        image.setContentType(picture.getContentType());
        image.setDescription(picture.getResource().getDescription());
        image.setOriginalFileName(picture.getOriginalFilename());
        image.setPathToFile(directory + image.getId());

        Galaxy galaxy = new Galaxy();
        galaxy.setId(id);
        image.setGalaxy(galaxy);

        imageRepository.save(image);


        Path path = Path.of(image.getPathToFile());
        picture.transferTo(path);


    }
}
