package by.gorbov.space.controller;

import by.gorbov.space.service.GalaxyService;
import by.gorbov.space.service.StarService;
import by.gorbov.space.service.dto.StarDto;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/stars")
public class StarController {


    private final StarService starService;

    public StarController(StarService starService) {

        this.starService = starService;
    }


    @PostMapping
    void postStars(@RequestBody List<StarDto> starDtos) {
        starService.createStars(starDtos);
    }

    @GetMapping
    List<StarDto> getAllStars() {
        return starService.getAllStars();
    }

    @PutMapping
    void updateStar(
            @RequestPart("image") MultipartFile image) throws IOException {

        File file = new File(Objects.requireNonNull(image.getOriginalFilename()));
        image.transferTo(file.toPath());
    }

    @GetMapping(value = "/download", produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseBody
    File download() throws IOException {
        File file = new File("C:/Users/37529/IdeaProjects/space/space.zip");
        return file;
    }


}
