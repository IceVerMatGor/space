package by.gorbov.space.repo;

import by.gorbov.space.entity.Astronomer;
import by.gorbov.space.service.dto.AddRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AstronomerRepository extends JpaRepository<Astronomer, Long> {

    Astronomer findByUsername(String username);

    Astronomer findByPassword(String password);



    @Modifying
    @Query(value = "INSERT INTO astronomer_authority VALUES(:astronomerId, :authorityId)",
    nativeQuery = true)
    void addAuthorityToAstronomer(Long astronomerId, Long authorityId);


}
