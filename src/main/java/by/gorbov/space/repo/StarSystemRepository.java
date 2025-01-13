package by.gorbov.space.repo;

import by.gorbov.space.entity.StarSystem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StarSystemRepository extends JpaRepository<StarSystem,Long> {
}
