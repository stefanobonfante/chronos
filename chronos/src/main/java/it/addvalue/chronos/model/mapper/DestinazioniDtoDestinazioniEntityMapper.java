package it.addvalue.chronos.model.mapper;

import it.addvalue.chronos.model.dto.DestinazioniDto;
import it.addvalue.chronos.model.entity.DestinazioniEntity;
import it.addvalue.chronos.model.entity.SpeseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DestinazioniDtoDestinazioniEntityMapper
        implements IDtoEntityBidirectionalMapper<DestinazioniDto, DestinazioniEntity> {

    @Override
    public DestinazioniDto toDto(DestinazioniEntity destinazioniEntity) {
        DestinazioniDto destinazioniDto = new DestinazioniDto();
        destinazioniDto.setKmViaggio(destinazioniEntity.getKmViaggio());
        destinazioniDto.setOreViaggio(destinazioniEntity.getOreViaggio());
        destinazioniDto.setDesDestinazione(destinazioniEntity.getDesDestinazione());
        destinazioniDto.setCodDestinazione(destinazioniEntity.getCodDestinazione());
        return destinazioniDto;
    }

    @Override
    public DestinazioniEntity toEntity(DestinazioniDto destinazioniDto) {
        DestinazioniEntity destinazioniEntity = new DestinazioniEntity();
        destinazioniEntity.setKmViaggio(destinazioniDto.getKmViaggio());
        destinazioniEntity.setOreViaggio(destinazioniDto.getOreViaggio());
        destinazioniEntity.setDesDestinazione(destinazioniDto.getDesDestinazione());
        destinazioniEntity.setCodDestinazione(destinazioniDto.getCodDestinazione());
        return destinazioniEntity;
    }

    @Override
    public List<DestinazioniDto> toDtos(List<DestinazioniEntity> entityList) {
        return IDtoEntityBidirectionalMapper.super.toDtos(entityList);
    }

    @Override
    public List<DestinazioniEntity> toEntities(List<DestinazioniDto> dtoList) {
        return IDtoEntityBidirectionalMapper.super.toEntities(dtoList);
    }
}
