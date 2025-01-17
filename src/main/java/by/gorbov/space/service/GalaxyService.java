package by.gorbov.space.service;

import by.gorbov.space.entity.Galaxy;
import by.gorbov.space.service.dto.GalaxyDto;
import by.gorbov.space.service.mapper.GalaxyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;


public interface GalaxyService {


    void uploadPicture(MultipartFile picture,GalaxyDto galaxyDto);

    byte[] getPicture(Long id);

    List<GalaxyDto> getGalaxies();




}
