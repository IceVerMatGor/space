package by.gorbov.space.repo;

import by.gorbov.space.entity.Astronomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AstronomerRepository extends JpaRepository<Astronomer, Long> {
}
