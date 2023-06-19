package it.addvalue.chronos.model.mapper;

import it.addvalue.chronos.model.dto.SpeseDto;
import it.addvalue.chronos.model.entity.SpeseEntity;
import org.springframework.stereotype.Component;

@Component
public class SpesaDtoSpeseEntityMapper implements IDtoEntityBidirectionalMapper<SpeseDto, SpeseEntity> {

  @Override
  public SpeseDto toDto(SpeseEntity speseEntity) {
    SpeseDto speseDto = new SpeseDto();
    speseDto.setAnno(speseEntity.getAnno());
    speseDto.setMese(speseEntity.getMese());
    speseDto.setCodUtente(speseEntity.getCodUtente());
    return speseDto;
  }

  @Override
  public SpeseEntity toEntity(SpeseDto speseDto) {
    SpeseEntity speseEntity = new SpeseEntity();
    speseEntity.setAnno(speseDto.getAnno());
    speseEntity.setMese(speseDto.getMese());
    speseEntity.setCodUtente(speseDto.getCodUtente());
    return speseEntity;
  }
}
