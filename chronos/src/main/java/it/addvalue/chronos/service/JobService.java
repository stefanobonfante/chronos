package it.addvalue.chronos.service;

import it.addvalue.chronos.core.exception.CustomException;
import it.addvalue.chronos.model.dto.JobDto;
import it.addvalue.chronos.model.entity.JobStatoEntity;
import it.addvalue.chronos.model.entity.JobTipoEntity;
import it.addvalue.chronos.model.mapper.JobDtoJobEntityMapper;
import it.addvalue.chronos.repository.JobRepository;
import it.addvalue.chronos.repository.JobStatoRepository;
import it.addvalue.chronos.repository.JobTipoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class JobService {
  private static final String TABLE_NAME = "TB_STATO_JOB";
  protected static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

  @Autowired protected JobStatoRepository statoRepository;
  @Autowired protected JobTipoRepository tipoRepository;

  @Autowired protected JobRepository repository;

  @Autowired protected JobDtoJobEntityMapper mapper;

  public List<JobStatoEntity> recuperoStatiJob() {
    return statoRepository.recuperoStatiJob();
  }

  public List<JobTipoEntity> recuperoTipoJob() {
    return tipoRepository.recuperoTipoJob();
  }

  public void salvataggioJob(List<JobDto> jobs) throws CustomException {
    for (JobDto job : jobs) {
      if (repository.existsById(job.getCodJob())) {
        throw new CustomException("Errore codice Job già presente nel DB, riprovare");
      } else {
        if (job.getDesJobBreve() == null
            && job.getDesJob() == null
            && job.getCodTipoJob() == null
            && job.getDataInizio() == null) {
          throw new CustomException("Errore campo obbligatorio mancante, riprovare");
        } else if (job.getCodCliente() == null && job.getCodTipoJob() == null) {
          throw new CustomException(
              "Attenzione!!! campi non correttamente valorizzati. Salvataggio non eseguito");
        } else {
          if (job.getGgCaricati().equals(0)) {
            job.setGgCaricati(new BigDecimal("0"));
          }
          if (job.getGgPagamento().equals(0)) {
            job.setGgPagamento(new BigDecimal("0"));
          }
          if (job.getGgFineStima().equals(0)) {
            job.setGgFineStima(new BigDecimal("0"));
          }
          if (job.getGgFineVendi().equals(0)) {
            job.setGgFineVendi(new BigDecimal("0"));
          }
          if (job.getSpeseJob().equals(0)) {
            job.setSpeseJob(new BigDecimal("0"));
          }
          if (job.getGgVenduti().equals(0)) {
            job.setGgVenduti(new BigDecimal("0"));
          }
          if (job.getTariffa().equals(0)) {
            job.setTariffa(new BigDecimal("0"));
          }
          if (job.getCommStima().equals(0)) {
            job.setCommStima(new BigDecimal("0"));
          }
          if (job.getCommVendita().equals(0)) {
            job.setCommVendita(new BigDecimal("0"));
          }
          if (job.getGgStima().equals(0)) {
            job.setGgStima(new BigDecimal("0"));
          }
          if (job.getDesJob() == null) {
            job.setCodJob("");
          }
          if (job.getJobInterno() == null) {
            job.setJobInterno("N");
          }
          if (job.getNota().equals("")) {
            job.setNota("Nessuna");
          }
          if (job.getCodCCosto() == null) {
            job.setCodCCosto("0000");
          }
          if (job.getObbNote() == null) {
            job.setObbNote("N");
          }
          if (job.getNumOrdine() == null) {
            job.setNumOrdine("0");
          }
          if (job.getCodStatoProp() == null) {
            job.setCodStatoProp("F");
          }
          if (job.getDataFinePrev().equals("")) {
            job.setDataFinePrev("00010101");
          }
          if (job.getDataOrdine() == null) {
            job.setDataOrdine("00010101");
          }
          if (job.getDataProposta() == null) {
            job.setDataProposta("00010101");
          }
          job.setRespCliente("Nessuno");
          job.setRifApplCli("Nessuno");
          job.setRifBuyerCli("Nessuno");
          job.setPrecAttendib(new BigDecimal(0));
          job.setSpeseForfait(new BigDecimal(0));
          job.setCodCresp("0");
          job.setCodSocieta("ADV");
          job.setObbTask("S");
          job.setObbSubtask("S");
          job.setObbSubsubtask("N");
          job.setObbAttivita("S");
          job.setFlgMezzore("O");
          job.setFlgBuonopasto("S");
          job.setFlgRiepilogo("L");

          repository.save(mapper.toEntity(job));
        }
      }
    }
  }

  public boolean modificaJob(List<JobDto> jobs) throws CustomException {
    for (JobDto job : jobs) {
      boolean flag = false;
      if (repository.existsById(job.getCodJob())) {
        if (job.getDesJobBreve() == null
            && job.getDesJob() == null
            && job.getCodTipoJob() == null
            && job.getDataInizio() == null) {
          throw new CustomException("Errore campo obbligatorio mancante, riprovare");
        } else if (job.getCodCliente() == null && job.getCodTipoJob() == null) {
          throw new CustomException(
              "Attenzione!!! campi non correttamente valorizzati. Salvataggio non eseguito");
        } else {
          if (job.getGgCaricati().equals(0)) {
            job.setGgCaricati(new BigDecimal("0"));
          }
          if (job.getGgPagamento().equals(0)) {
            job.setGgPagamento(new BigDecimal("0"));
          }
          if (job.getGgFineStima().equals(0)) {
            job.setGgFineStima(new BigDecimal("0"));
          }
          if (job.getGgFineVendi().equals(0)) {
            job.setGgFineVendi(new BigDecimal("0"));
          }
          if (job.getSpeseJob().equals(0)) {
            job.setSpeseJob(new BigDecimal("0"));
          }
          if (job.getGgVenduti().equals(0)) {
            job.setGgVenduti(new BigDecimal("0"));
          }
          if (job.getTariffa().equals(0)) {
            job.setTariffa(new BigDecimal("0"));
          }
          if (job.getCommStima().equals(0)) {
            job.setCommStima(new BigDecimal("0"));
          }
          if (job.getCommVendita().equals(0)) {
            job.setCommVendita(new BigDecimal("0"));
          }
          if (job.getGgStima().equals(0)) {
            job.setGgStima(new BigDecimal("0"));
          }
          if (job.getDesJob() == null) {
            job.setCodJob("");
          }
          if (job.getJobInterno() == null) {
            job.setJobInterno("N");
          }
          if (job.getNota().equals("")) {
            job.setNota("Nessuna");
          }
          if (job.getCodCCosto() == null) {
            job.setCodCCosto("0000");
          }
          if (job.getObbNote() == null) {
            job.setObbNote("N");
          }
          if (job.getNumOrdine() == null) {
            job.setNumOrdine("0");
          }
          if (job.getCodStatoProp() == null) {
            job.setCodStatoProp("F");
          }
          if (job.getDataFinePrev().equals("")) {
            job.setDataFinePrev("00010101");
          }
          if (job.getDataOrdine() == null) {
            job.setDataOrdine("00010101");
          }
          if (job.getDataProposta() == null) {
            job.setDataProposta("00010101");
          }
          job.setRespCliente("Nessuno");
          job.setRifApplCli("Nessuno");
          job.setRifBuyerCli("Nessuno");
          job.setPrecAttendib(new BigDecimal(0));
          job.setSpeseForfait(new BigDecimal(0));
          job.setCodCresp("0");
          job.setCodSocieta("ADV");
          job.setObbTask("S");
          job.setObbSubtask("S");
          job.setObbSubsubtask("N");
          job.setObbAttivita("S");
          job.setFlgMezzore("O");
          job.setFlgBuonopasto("S");
          job.setFlgRiepilogo("L");

          repository.save(mapper.toEntity(job));
          flag = true;
        }
      } else {
        throw new CustomException("Errore codice Job non presente nel DB, riprovare");
      }
      return flag;
    }
    return false;
  }

  public JobDto recuperoDettaglioJob(String codJob, String codCliente) throws CustomException {
    return mapper.toDto(repository.recuperoDettagliJob(codJob, codCliente));
  }

  public void controlloChiusuraJob(String codJob) throws CustomException {
    Optional<JobDto> jobO = Optional.of(mapper.toDto(repository.recuperoJob(codJob)));
    if (jobO.isPresent()) {
      JobDto job = jobO.get();
      if (!job.getCodStatoJob().equals("C")) {
        job.setCodStatoJob("C");
      }
      repository.save(mapper.toEntity(job));
    } else {
      throw new CustomException("Errore");
    }
  }
}
