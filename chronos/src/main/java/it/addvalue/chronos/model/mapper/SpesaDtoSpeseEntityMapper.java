package it.addvalue.chronos.model.mapper;

import it.addvalue.chronos.model.dto.SpeseDto;
import it.addvalue.chronos.model.entity.SpeseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SpesaDtoSpeseEntityMapper
    implements IDtoEntityBidirectionalMapper<SpeseDto, SpeseEntity> {

  @Override
  public SpeseDto toDto(SpeseEntity speseEntity) {
    SpeseDto speseDto = new SpeseDto();
    speseDto.setIdSpese(speseEntity.getIdSpese());
    speseDto.setCodUtente(speseEntity.getCodUtente());
    speseDto.setCodJob(speseEntity.getCodJob());
    speseDto.setAnno(speseEntity.getAnno());
    speseDto.setMese(speseEntity.getMese());
    speseDto.setGiorno(speseEntity.getGiorno());
    speseDto.setPercorso(speseEntity.getPercorso());
    speseDto.setKmPercorsi(speseEntity.getKmPercorsi());
    speseDto.setRimborsoKm(speseEntity.getRimborsoKm());
    speseDto.setCarburante(speseEntity.getCarburante());
    speseDto.setPedaggi(speseEntity.getPedaggi());
    speseDto.setAltro(speseEntity.getAltro());
    speseDto.setAnticipi(speseEntity.getAnticipi());
    speseDto.setParcheggi(speseEntity.getParcheggi());
    speseDto.setTrasporti(speseEntity.getTrasporti());
    speseDto.setTotSpese(speseEntity.getTotSpese());
    speseDto.setTrasferta(speseEntity.getTrasferta());
    speseDto.setFlgAndata(speseEntity.getFlgAndata());
    speseDto.setFlgRitorno(speseEntity.getFlgRitorno());
    speseDto.setTotOreViaggio(speseEntity.getTotOreViaggio());
    speseDto.setReperibilita(speseEntity.getReperibilita());
    speseDto.setFlgAutoPf(speseEntity.getFlgAutoPf());
    speseDto.setFlgAutoAr(speseEntity.getFlgAutoAr());
    return speseDto;
  }

  @Override
  public SpeseEntity toEntity(SpeseDto speseDto) {
    SpeseEntity speseEntity = new SpeseEntity();
    speseEntity.setIdSpese(speseDto.getIdSpese());
    speseEntity.setCodUtente(speseDto.getCodUtente());
    speseEntity.setCodJob(speseDto.getCodJob());
    speseEntity.setAnno(speseDto.getAnno());
    speseEntity.setMese(speseDto.getMese());
    speseEntity.setGiorno(speseDto.getGiorno());
    speseEntity.setPercorso(speseDto.getPercorso());
    speseEntity.setKmPercorsi(speseDto.getKmPercorsi());
    speseEntity.setRimborsoKm(speseDto.getRimborsoKm());
    speseEntity.setCarburante(speseDto.getCarburante());
    speseEntity.setPedaggi(speseDto.getPedaggi());
    speseEntity.setAltro(speseDto.getAltro());
    speseEntity.setAnticipi(speseDto.getAnticipi());
    speseEntity.setParcheggi(speseDto.getParcheggi());
    speseEntity.setTrasporti(speseDto.getTrasporti());
    speseEntity.setTotSpese(speseDto.getTotSpese());
    speseEntity.setTrasferta(speseDto.getTrasferta());
    speseEntity.setFlgAndata(speseDto.getFlgAndata());
    speseEntity.setFlgRitorno(speseDto.getFlgRitorno());
    speseEntity.setTotOreViaggio(speseDto.getTotOreViaggio());
    speseEntity.setReperibilita(speseDto.getReperibilita());
    speseEntity.setFlgAutoPf(speseDto.getFlgAutoPf());
    speseEntity.setFlgAutoAr(speseDto.getFlgAutoAr());
    return speseEntity;
  }

  @Override
  public List<SpeseDto> toDtos(List<SpeseEntity> entityList) {
    return IDtoEntityBidirectionalMapper.super.toDtos(entityList);
  }

  @Override
  public List<SpeseEntity> toEntities(List<SpeseDto> dtoList) {
    return IDtoEntityBidirectionalMapper.super.toEntities(dtoList);
  }
}
