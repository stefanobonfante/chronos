package it.addvalue.chronos.model.mapper;

import it.addvalue.chronos.model.dto.carichiDTO;
import it.addvalue.chronos.model.entity.CarichiEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarichiDTOEntityMapper
        implements IDtoEntityBidirectionalMapper<carichiDTO, CarichiEntity> {

    @Override
    public carichiDTO toDto(CarichiEntity entity) {
        carichiDTO carDto = new carichiDTO();
        carDto.setAnno(entity.getAnno());
        carDto.setAutore(entity.getAutore());
        carDto.setIdCarico(entity.getIdCarico());
        carDto.setCodUtente(entity.getCodUtente());
        carDto.setMese(entity.getMese());
        carDto.setGiorno(entity.getGiorno());
        carDto.setCodJob(entity.getCodJob());
        carDto.setCodTask(entity.getCodTask());
        carDto.setCodSTask(entity.getCodSTask());
        carDto.setCodSSTask(entity.getCodSSTask());
        carDto.setCodAttivita(entity.getCodAttivita());
        carDto.setOre(entity.getOre());
        carDto.setCodLgLav(entity.getCodLgLav());
        carDto.setFlgChiuso(entity.getFlgChiuso());
        carDto.setFlgStr(entity.getFlgStr());
        carDto.setFlgLavoroRem(entity.getFlgLavoroRem());
        carDto.setUltimaMod(entity.getOraInizioStr());
        carDto.setOraInizioStr(entity.getOraInizioStr());
        carDto.setNote(entity.getNote());

        return carDto;
    }

    @Override
    public CarichiEntity toEntity(carichiDTO dto) {
        CarichiEntity entity = new CarichiEntity();
        entity.setAnno(dto.getAnno());
        entity.setAutore(dto.getAutore());
        entity.setIdCarico(dto.getIdCarico());
        entity.setCodUtente(dto.getCodUtente());
        entity.setMese(dto.getMese());
        entity.setGiorno(dto.getGiorno());
        entity.setCodJob(dto.getCodJob());
        entity.setCodTask(dto.getCodTask());
        entity.setCodSTask(dto.getCodSTask());
        entity.setCodSSTask(dto.getCodSSTask());
        entity.setCodAttivita(dto.getCodAttivita());
        entity.setOre(dto.getOre());
        entity.setCodLgLav(dto.getCodLgLav());
        entity.setFlgChiuso(dto.getFlgChiuso());
        entity.setFlgStr(dto.getFlgStr());
        entity.setFlgLavoroRem(dto.getFlgLavoroRem());
        entity.setUltimaMod(dto.getOraInizioStr());
        entity.setOraInizioStr(dto.getOraInizioStr());
        entity.setNote(dto.getNote());

        return entity;
    }

    @Override
    public List<CarichiEntity> toEntities(List<carichiDTO> dtoList) {
        return IDtoEntityBidirectionalMapper.super.toEntities(dtoList);
    }

    @Override
    public List<carichiDTO> toDtos(List<CarichiEntity> entityList) {
        return IDtoEntityBidirectionalMapper.super.toDtos(entityList);
    }
}
