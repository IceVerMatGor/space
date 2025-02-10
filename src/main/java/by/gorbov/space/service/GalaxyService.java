package by.gorbov.space.service;

import by.gorbov.space.entity.Image;
import by.gorbov.space.service.dto.GalaxyDto;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


public interface GalaxyService {


    void uploadPicture(MultipartFile picture,GalaxyDto galaxyDto);

    Resource getPicture(Long id);

    List<GalaxyDto> getGalaxies();

    void putPicture(MultipartFile picture, Long id) throws IOException;
}
