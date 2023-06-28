package it.addvalue.chronos.model.mapper;

import it.addvalue.chronos.model.dto.StimeDTO;
import it.addvalue.chronos.model.entity.StimeEntity;
import it.addvalue.chronos.model.entity.StimeProjection;
import org.springframework.stereotype.Component;

@Component
public class StimeMapper {

  public StimeDTO toDto(StimeEntity entity) {
    StimeDTO dto = new StimeDTO();
    dto.setCodJob(entity.getCodJob());
    dto.setDesJob(entity.getDesJob());
    dto.setCodTask(entity.getCodTask());
    dto.setDesTask(entity.getDesTask());
    dto.setCodSubtask(entity.getCodSubtask());
    dto.setDesSubtask(entity.getDesSubtask());
    dto.setCodSubsubtask(entity.getCodSubsubtask());
    dto.setDesSubsubtask(entity.getDesSubsubtask());
    dto.setCodAttivita(entity.getCodAttivita());
    dto.setOre(entity.getOre());
    dto.setNote(entity.getNote());
    dto.setTmsUltimamod(entity.getTmsUltimamod());
    dto.setColonnaFittizzia(entity.getColonnaFittizzia());
    dto.setIdStima(entity.getIdStima());
    return dto;
  }

  public StimeEntity toEntity(StimeDTO dto) {
    StimeEntity entity = new StimeEntity();
    entity.setCodJob(dto.getCodJob());
    entity.setDesJob(dto.getDesJob());
    entity.setCodTask(dto.getCodTask());
    entity.setDesTask(dto.getDesTask());
    entity.setCodSubtask(dto.getCodSubtask());
    entity.setDesSubtask(dto.getCodSubtask());
    entity.setCodSubsubtask(dto.getCodSubsubtask());
    entity.setDesSubsubtask(dto.getDesSubsubtask());
    entity.setCodAttivita(dto.getCodAttivita());
    entity.setOre(dto.getOre());
    entity.setNote(dto.getNote());
    entity.setTmsUltimamod(dto.getTmsUltimamod());
    entity.setColonnaFittizzia(dto.getColonnaFittizzia());
    entity.setIdStima(dto.getIdStima());
    return entity;
  }

  public StimeProjection toProjection(StimeEntity entity) {
    StimeProjection stimeProjection = new StimeProjection();
    stimeProjection.setCodJob(toDto(entity).getCodJob());
    stimeProjection.setCodTask(toDto(entity).getCodTask());
    stimeProjection.setDesTask(toDto(entity).getDesTask());
    return stimeProjection;
  }
}
