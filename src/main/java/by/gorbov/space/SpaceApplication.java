package by.gorbov.space;

import by.gorbov.space.entity.Astronomer;
import by.gorbov.space.entity.Galaxy;
import by.gorbov.space.entity.Planet;
import by.gorbov.space.lab.Singleton;
import by.gorbov.space.repo.AstronomerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpaceApplication {
    public static void main(String[] args) {
		SpringApplication.run(SpaceApplication.class, args);
	}



}
