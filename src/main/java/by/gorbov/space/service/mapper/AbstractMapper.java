package by.gorbov.space.service.mapper;

public interface AbstractMapper<ENTITY,DTO> {

    DTO toDto(ENTITY entity);
    ENTITY toEntity(DTO dto);

}
