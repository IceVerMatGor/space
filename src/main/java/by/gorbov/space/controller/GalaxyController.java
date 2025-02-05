package by.gorbov.space.controller;

import by.gorbov.space.entity.Galaxy;
import by.gorbov.space.service.GalaxyService;
import by.gorbov.space.service.GalaxyServiceImpl;
import by.gorbov.space.service.dto.GalaxyDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.MediaTypeFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/galaxies")
public class GalaxyController {


    private final GalaxyService galaxyService;

    public GalaxyController(GalaxyService galaxyService) {
        this.galaxyService = galaxyService;
    }



    @PostMapping(path = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Boolean uploadPicture(@RequestPart(value = "picture", required = false) MultipartFile picture,
                                 @RequestPart(value = "galaxy") GalaxyDto galaxyDto) {
        galaxyService.uploadPicture(picture, galaxyDto);
        return Boolean.TRUE;
    }



    @GetMapping(path = "/download/{id}")
    public Resource getPicture(@PathVariable Long id) {
        return galaxyService.getPicture(id);
    }


    @GetMapping
    public List<GalaxyDto> getGalaxies() {
        return galaxyService.getGalaxies();
    }


}
