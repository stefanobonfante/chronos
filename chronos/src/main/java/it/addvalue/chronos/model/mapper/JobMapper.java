package it.addvalue.chronos.model.mapper;

import it.addvalue.chronos.model.dto.JobDTO;
import it.addvalue.chronos.model.entity.JobEntity;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class JobMapper implements IDtoEntityBidirectionalMapper<JobDTO, JobEntity> {
  @Override
  public JobDTO toDto(JobEntity entity) {
    JobDTO dto = new JobDTO();
    dto.setCodJob(entity.getCodJob());
    dto.setDesJob(entity.getDesJob());
    dto.setDesJobBreve(entity.getDesJobBreve());
    dto.setCodCresp(entity.getCodCresp());
    dto.setCodSocieta(entity.getCodSocieta());
    dto.setCodCliente(entity.getCodCliente());
    dto.setRespJob(entity.getRespJob());
    dto.setGgPagamento(entity.getGgPagamento());
    dto.setProtocollo(entity.getProtocollo());
    dto.setJobInterno(entity.getJobInterno());
    dto.setDataInizio(entity.getDataInizio());
    dto.setCodStatoJob(entity.getCodStatoJob());
    dto.setGgStima(entity.getGgStima());
    dto.setGgVenduti(entity.getGgVenduti());
    dto.setTariffa(entity.getTariffa());
    dto.setCommStima(entity.getCommStima());
    dto.setCommVendita(entity.getCommVendita());
    dto.setGgCaricati(entity.getGgCaricati());
    dto.setGgFineStima(entity.getGgFineStima());
    dto.setGgFineVendi(entity.getGgFineVendi());
    dto.setSpeseJob(entity.getSpeseJob());
    dto.setCodTipoJob(entity.getCodTipoJob());
    dto.setCancellato(entity.getCancellato());
    dto.setCodCCosto(entity.getCodCCosto());
    dto.setDataOrdine(entity.getDataOrdine());
    dto.setNumOrdine(entity.getNumOrdine());
    dto.setDataProposta(entity.getDataProposta());
    dto.setRespCliente(entity.getRespCliente());
    dto.setRifApplCli(entity.getRifApplCli());
    dto.setRifBuyerCli(entity.getRifBuyerCli());
    dto.setCodStatoProp(entity.getCodStatoProp());
    dto.setPrecAttendib(entity.getPrecAttendib());
    dto.setNota(entity.getNota());
    dto.setDataFinePrev(entity.getDataFinePrev());
    dto.setSpeseForfait(entity.getSpeseForfait());
    dto.setObbTask(entity.getObbTask());
    dto.setObbSubtask(entity.getObbSubtask());
    dto.setObbSubsubtask(entity.getObbSubsubtask());
    dto.setObbAttivita(entity.getObbAttivita());
    dto.setObbNote(entity.getObbNote());
    dto.setFlgMezzore(entity.getFlgMezzore());
    dto.setFlgBuonopasto(entity.getFlgBuonopasto());
    dto.setFlgRieplogo(entity.getFlgRieplogo());
    return dto;
  }

  @Override
  public List<JobEntity> toEntities(List<JobDTO> dtoList) {
    return IDtoEntityBidirectionalMapper.super.toEntities(dtoList);
  }

  public List<JobDTO> toDtos(List<JobEntity> entityList) {
    return IDtoEntityBidirectionalMapper.super.toDtos(entityList);
  }

  @Override
  public JobEntity toEntity(JobDTO dto) {
    JobEntity entity = new JobEntity();
    entity.setCodJob(dto.getCodJob());
    entity.setDesJob(dto.getDesJob());
    entity.setDesJobBreve(dto.getDesJobBreve());
    entity.setCodCresp(dto.getCodCresp());
    entity.setCodSocieta(dto.getCodSocieta());
    entity.setCodCliente(dto.getCodCliente());
    entity.setRespJob(dto.getRespJob());
    entity.setGgPagamento(dto.getGgPagamento());
    entity.setProtocollo(dto.getProtocollo());
    entity.setJobInterno(dto.getJobInterno());
    entity.setDataInizio(dto.getDataInizio());
    entity.setCodStatoJob(dto.getCodStatoJob());
    entity.setGgStima(dto.getGgStima());
    entity.setGgVenduti(dto.getGgVenduti());
    entity.setTariffa(dto.getTariffa());
    entity.setCommStima(dto.getCommStima());
    entity.setCommVendita(dto.getCommVendita());
    entity.setGgCaricati(dto.getGgCaricati());
    entity.setGgFineStima(dto.getGgFineStima());
    entity.setGgFineVendi(dto.getGgFineVendi());
    entity.setSpeseJob(dto.getSpeseJob());
    entity.setCodTipoJob(dto.getCodTipoJob());
    entity.setCancellato(dto.getCancellato());
    entity.setCodCCosto(dto.getCodCCosto());
    entity.setDataOrdine(dto.getDataOrdine());
    entity.setNumOrdine(dto.getNumOrdine());
    entity.setDataProposta(dto.getDataProposta());
    entity.setRespCliente(dto.getRespCliente());
    entity.setRifApplCli(dto.getRifApplCli());
    entity.setRifBuyerCli(dto.getRifBuyerCli());
    entity.setCodStatoProp(dto.getCodStatoProp());
    entity.setPrecAttendib(dto.getPrecAttendib());
    entity.setNota(dto.getNota());
    entity.setDataFinePrev(dto.getDataFinePrev());
    entity.setSpeseForfait(dto.getSpeseForfait());
    entity.setObbTask(dto.getObbTask());
    entity.setObbSubtask(dto.getObbSubtask());
    entity.setObbSubsubtask(dto.getObbSubsubtask());
    entity.setObbAttivita(dto.getObbAttivita());
    entity.setObbNote(dto.getObbNote());
    entity.setFlgMezzore(dto.getFlgMezzore());
    entity.setFlgBuonopasto(dto.getFlgBuonopasto());
    entity.setFlgRieplogo(dto.getFlgRieplogo());
    return entity;
  }
}
