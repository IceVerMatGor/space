package by.gorbov.space.service.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
public class Login {


    @NotBlank
    @Size(min = 4, max = 20)
    @Pattern(regexp = "[a-zA-Z0-9]")
    private String username;

    @NotBlank
    @Size(min = 7, max = 20)
    private String password;
}
