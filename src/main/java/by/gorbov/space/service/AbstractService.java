package by.gorbov.space.service;

import by.gorbov.space.entity.AbstractEntity;
import by.gorbov.space.service.mapper.AbstractMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;

@Slf4j

public abstract class AbstractService<
        ENTITY extends AbstractEntity
        , DTO
        , REPO extends JpaRepository<ENTITY, Long>
        , MAPPER extends AbstractMapper<ENTITY,DTO>
        > {

    private final REPO repository;
    private final MAPPER mapper;

    protected AbstractService(REPO repository, MAPPER mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    void save(DTO dto) {
        ENTITY entity = mapper.toEntity(dto);
        repository.save(entity);
        log.info("Saved entity: {}", entity);
    }

    DTO get(Long id) {
        ENTITY entity = repository.findById(id).get();
        log.info("get entity: {}", entity);
        return mapper.toDto(entity);
    }

    void update(DTO dto) {
        ENTITY entity = mapper.toEntity(dto);
        repository.save(entity);
        log.info("Updated: {} {}", entity.getClass(), entity);
    }

    void delete(Long id) {
        repository.deleteById(id);
        log.info("Deleted with id {}", id);
    }


}
