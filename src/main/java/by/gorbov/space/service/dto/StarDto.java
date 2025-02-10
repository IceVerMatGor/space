package by.gorbov.space.service.dto;

import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StarDto {

    @Min(1)
    private Long id;

    private String name;

    private Long starSystemId;


    private String imagePath;


}
