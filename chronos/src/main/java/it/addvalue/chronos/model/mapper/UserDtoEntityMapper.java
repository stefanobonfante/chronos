package it.addvalue.chronos.model.mapper;

import it.addvalue.chronos.model.dto.SpeseDto;
import it.addvalue.chronos.model.entity.SpeseEntity;
import org.springframework.stereotype.Component;

import it.addvalue.chronos.model.dto.UserDto;
import it.addvalue.chronos.model.entity.User;

@Component
public class UserDtoEntityMapper implements IDtoEntityBidirectionalMapper<SpeseDto, SpeseEntity> {

  @Override
  public SpeseDto toDto(SpeseEntity entity) {
    SpeseDto speseDto = new SpeseDto();
    speseDto.setAnno(entity.getAnno());
    speseDto.setMese(entity.getMese());
    speseDto.setCodUtente(entity.getCodUtente());
    return speseDto;
  }

  @Override
  public SpeseEntity toEntity(SpeseDto dto) {
    SpeseEntity speseEntity = new SpeseEntity();
    speseEntity.setAnno(speseEntity.getAnno());
    speseEntity.setMese(speseEntity.getMese());
    speseEntity.setCodUtente(speseEntity.getCodUtente());
    return speseEntity;
  }
}
