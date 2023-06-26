package it.addvalue.chronos.model.mapper;

import it.addvalue.chronos.model.dto.JobDto;
import it.addvalue.chronos.model.entity.JobEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JobDtoJobEntityMapper implements IDtoEntityBidirectionalMapper<JobDto, JobEntity> {
    @Override
    public JobDto toDto(JobEntity jobEntity) {
        JobDto jobDto = new JobDto();
        jobDto.setCodJob(jobEntity.getCodJob());
        jobDto.setDesJob(jobEntity.getDesJob());
        jobDto.setDesJobBreve(jobEntity.getDesJobBreve());
        jobDto.setCodCresp(jobEntity.getCodCresp());
        jobDto.setCodSocieta(jobEntity.getCodSocieta());
        jobDto.setCodCliente(jobEntity.getCodCliente());
        jobDto.setRespJob(jobEntity.getRespJob());
        jobDto.setGgPagamento(jobEntity.getGgPagamento());
        jobDto.setProtocollo(jobEntity.getProtocollo());
        jobDto.setJobInterno(jobEntity.getJobInterno());
        jobDto.setDataInizio(jobEntity.getDataInizio());
        jobDto.setCodStatoJob(jobEntity.getCodStatoJob());
        jobDto.setGgStima(jobEntity.getGgStima());
        jobDto.setGgVenduti(jobEntity.getGgVenduti());
        jobDto.setTariffa(jobEntity.getTariffa());
        jobDto.setCommStima(jobEntity.getCommStima());
        jobDto.setCommVendita(jobEntity.getCommVendita());
        jobDto.setGgCaricati(jobEntity.getGgCaricati());
        jobDto.setGgFineStima(jobEntity.getGgFineStima());
        jobDto.setGgFineVendi(jobEntity.getGgFineVendi());
        jobDto.setSpeseJob(jobEntity.getSpeseJob());
        jobDto.setCodTipoJob(jobEntity.getCodTipoJob());
        jobDto.setCancellato(jobEntity.getCancellato());
        jobDto.setCodCCosto(jobEntity.getCodCCosto());
        jobDto.setDataOrdine(jobEntity.getDataOrdine());
        jobDto.setNumOrdine(jobEntity.getNumOrdine());
        jobDto.setDataProposta(jobEntity.getDataProposta());
        jobDto.setRespCliente(jobEntity.getRespCliente());
        jobDto.setRifApplCli(jobEntity.getRifApplCli());
        jobDto.setRifBuyerCli(jobEntity.getRifBuyerCli());
        jobDto.setCodStatoProp(jobEntity.getCodStatoProp());
        jobDto.setPrecAttendib(jobEntity.getPrecAttendib());
        jobDto.setNota(jobEntity.getNota());
        jobDto.setDataFinePrev(jobEntity.getDataFinePrev());
        jobDto.setSpeseForfait(jobEntity.getSpeseForfait());
        jobDto.setObbTask(jobEntity.getObbTask());
        jobDto.setObbSubtask(jobEntity.getObbSubtask());
        jobDto.setObbSubsubtask(jobEntity.getObbSubsubtask());
        jobDto.setObbAttivita(jobEntity.getObbAttivita());
        jobDto.setObbNote(jobEntity.getObbNote());
        jobDto.setFlgMezzore(jobEntity.getFlgMezzore());
        jobDto.setFlgBuonopasto(jobEntity.getFlgBuonopasto());
        jobDto.setFlgRiepilogo(jobEntity.getFlgRiepilogo());
        return jobDto;
    }

    @Override
    public JobEntity toEntity(JobDto jobDto) {
        JobEntity jobEntity = new JobEntity();
        jobEntity.setCodJob(jobDto.getCodJob());
        jobEntity.setDesJob(jobDto.getDesJob());
        jobEntity.setDesJobBreve(jobDto.getDesJobBreve());
        jobEntity.setCodCresp(jobDto.getCodCresp());
        jobEntity.setCodSocieta(jobDto.getCodSocieta());
        jobEntity.setCodCliente(jobDto.getCodCliente());
        jobEntity.setRespJob(jobDto.getRespJob());
        jobEntity.setGgPagamento(jobDto.getGgPagamento());
        jobEntity.setProtocollo(jobDto.getProtocollo());
        jobEntity.setJobInterno(jobDto.getJobInterno());
        jobEntity.setDataInizio(jobDto.getDataInizio());
        jobEntity.setCodStatoJob(jobDto.getCodStatoJob());
        jobEntity.setGgStima(jobDto.getGgStima());
        jobEntity.setGgVenduti(jobDto.getGgVenduti());
        jobEntity.setTariffa(jobDto.getTariffa());
        jobEntity.setCommStima(jobDto.getCommStima());
        jobEntity.setCommVendita(jobDto.getCommVendita());
        jobEntity.setGgCaricati(jobDto.getGgCaricati());
        jobEntity.setGgFineStima(jobDto.getGgFineStima());
        jobEntity.setGgFineVendi(jobDto.getGgFineVendi());
        jobEntity.setSpeseJob(jobDto.getSpeseJob());
        jobEntity.setCodTipoJob(jobDto.getCodTipoJob());
        jobEntity.setCancellato(jobDto.getCancellato());
        jobEntity.setCodCCosto(jobDto.getCodCCosto());
        jobEntity.setDataOrdine(jobDto.getDataOrdine());
        jobEntity.setNumOrdine(jobDto.getNumOrdine());
        jobEntity.setDataProposta(jobDto.getDataProposta());
        jobEntity.setRespCliente(jobDto.getRespCliente());
        jobEntity.setRifApplCli(jobDto.getRifApplCli());
        jobEntity.setRifBuyerCli(jobDto.getRifBuyerCli());
        jobEntity.setCodStatoProp(jobDto.getCodStatoProp());
        jobEntity.setPrecAttendib(jobDto.getPrecAttendib());
        jobEntity.setNota(jobDto.getNota());
        jobEntity.setDataFinePrev(jobDto.getDataFinePrev());
        jobEntity.setSpeseForfait(jobDto.getSpeseForfait());
        jobEntity.setObbTask(jobDto.getObbTask());
        jobEntity.setObbSubtask(jobDto.getObbSubtask());
        jobEntity.setObbSubsubtask(jobDto.getObbSubsubtask());
        jobEntity.setObbAttivita(jobDto.getObbAttivita());
        jobEntity.setObbNote(jobDto.getObbNote());
        jobEntity.setFlgMezzore(jobDto.getFlgMezzore());
        jobEntity.setFlgBuonopasto(jobDto.getFlgBuonopasto());
        jobEntity.setFlgRiepilogo(jobDto.getFlgRiepilogo());
        return jobEntity;
    }

    @Override
    public List<JobDto> toDtos(List<JobEntity> entityList) {
        return IDtoEntityBidirectionalMapper.super.toDtos(entityList);
    }

    @Override
    public List<JobEntity> toEntities(List<JobDto> dtoList) {
        return IDtoEntityBidirectionalMapper.super.toEntities(dtoList);
    }
}
