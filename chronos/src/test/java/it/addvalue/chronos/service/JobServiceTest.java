package it.addvalue.chronos.service;

import it.addvalue.chronos.core.exception.CustomException;
import it.addvalue.chronos.model.dto.JobDto;
import it.addvalue.chronos.model.dto.JobStatoDto;
import it.addvalue.chronos.model.entity.JobEntity;
import it.addvalue.chronos.model.entity.JobStatoEntity;
import it.addvalue.chronos.model.entity.JobTipoEntity;
import it.addvalue.chronos.model.mapper.JobDtoJobEntityMapper;
import it.addvalue.chronos.model.mapper.JobStatoDtoJobStatoEntityMapper;
import it.addvalue.chronos.model.mapper.JobTipoDtoJobTipoEntityMapper;
import it.addvalue.chronos.repository.JobRepository;
import it.addvalue.chronos.repository.JobStatoRepository;
import it.addvalue.chronos.repository.JobTipoRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;

@RunWith(MockitoJUnitRunner.Silent.class)
public class JobServiceTest {
  @InjectMocks JobService jobService;
  @Mock JobRepository jobRepository;
  @Mock JobDtoJobEntityMapper jobMapper;
  @Mock JobStatoRepository statoRepository;
  @Mock JobStatoDtoJobStatoEntityMapper statoMapper;
  @Mock JobTipoRepository tipoRepository;
  @Mock JobTipoDtoJobTipoEntityMapper mapper;

  @Test
  public void StatoTest() {
    JobStatoEntity jobEntity = mapperStatoDto();
    Mockito.when(statoRepository.recuperoStatiJob()).thenReturn(ottieniStatiJob());
    List<JobStatoEntity> result = ottieniStatiJob();

    jobService.recuperoStatiJob();



    Assert.assertNotNull(result);
    Assert.assertEquals(jobEntity, result.get(0));
  }

  @Test
  public void TipoTest() {
    JobTipoEntity jobEntity = mapperTipoDto();
    Mockito.when(tipoRepository.recuperoTipoJob()).thenReturn(ottieniTipoJob());
    List<JobTipoEntity> result = ottieniTipoJob();

    jobService.recuperoTipoJob();



    Assert.assertNotNull(result);
    Assert.assertEquals(jobEntity, result.get(0));
  }
  @Test
  public void SalvataggioJobTest1() throws CustomException {
    JobEntity jobEntity = mapperEntity();
    JobDto jobDto = mapperDto();
    Mockito.when(jobRepository.existsById(jobDto.getCodJob())).thenReturn(false);
    Mockito.when(jobMapper.toEntity(jobDto)).thenReturn(mapperEntity());
    Mockito.when(jobMapper.toEntity(any(JobDto.class))).thenReturn(mapperEntity());
    List<JobDto> jobs =
            getListJob();
    jobService.salvataggioJob(jobs);
    Mockito.verify(jobMapper).toEntity(any(JobDto.class));
    Mockito.verify(jobRepository).save(jobEntity);
    //doThrow(new CustomException("ERRORE")).when(jobRepository).save(jobEntity);
  }

  @Test
  public void SalvataggioJobTest2() throws CustomException {
    JobEntity jobEntity = mapperEntity();
    JobDto jobDto = mapperDto();
    Mockito.when(jobRepository.existsById(jobDto.getCodJob())).thenReturn(true);
    Mockito.when(jobMapper.toEntity(jobDto)).thenReturn(mapperEntity());
    Mockito.when(jobMapper.toEntity(any(JobDto.class))).thenReturn(mapperEntity());
    List<JobDto> jobs =
            getListJob();
    assertThatThrownBy(()->jobService.salvataggioJob(jobs)).isInstanceOf(CustomException.class).hasMessage("Errore codice Job già presente nel DB, riprovare");
  }

  private static List<JobDto> getListJob() {
    return Arrays.asList(
            new JobDto(
                    "AADD13009",
                    "Fatturazione",
                    "Fatturazione",
                    "0",
                    "ADV",
                    "ADV",
                    "domenicm",
                    new BigDecimal(0.0000),
                    "",
                    "S",
                    "20110101",
                    "C",
                    new BigDecimal(0.0000),
                    new BigDecimal(0.0000),
                    new BigDecimal(0.0000),
                    new BigDecimal(0.0000),
                    new BigDecimal(0.0000),
                    new BigDecimal(0.0000),
                    new BigDecimal(0.0000),
                    new BigDecimal(0.0000),
                    new BigDecimal(0.0000),
                    "",
                    "N",
                    "",
                    "00010101",
                    "0",
                    "00010101",
                    "Nessuno",
                    "Nessuno",
                    "Nessuno",
                    "N",
                    new BigDecimal(0.0000),
                    "Nessuna",
                    "00010101",
                    new BigDecimal(0.0000),
                    "N",
                    "N",
                    "N",
                    "N",
                    "N",
                    "O",
                    "S",
                    "N"));
  }

  @Test
  public void ModificaJobTest1() throws CustomException {
    JobEntity jobEntity = mapperEntity();
    JobDto jobDto = mapperDto();
    Mockito.when(jobRepository.existsById(jobDto.getCodJob())).thenReturn(true);
    Mockito.when(jobMapper.toEntity(jobDto)).thenReturn(mapperEntity());
    Mockito.when(jobMapper.toEntity(any(JobDto.class))).thenReturn(mapperEntity());
    List<JobDto> jobs =
            getListJob();
    jobService.modificaJob(jobs);
    Mockito.verify(jobMapper).toEntity(any(JobDto.class));
    Mockito.verify(jobRepository).save(jobEntity);
  }

  @Test
  public void ModificaJobTest2() throws CustomException {
    JobDto jobDto = mapperDto();
    jobDto.setDesJobBreve(null);
    jobDto.setDesJob(null);
    jobDto.setCodTipoJob(null);
    jobDto.setDataInizio(null);
    Mockito.when(jobRepository.existsById(jobDto.getCodJob())).thenReturn(true);
    Mockito.when(jobMapper.toEntity(jobDto)).thenReturn(mapperEntity());
    List<JobDto> jobs = asList(jobDto);
    assertThatThrownBy(()->jobService.modificaJob(jobs)).isInstanceOf(CustomException.class).hasMessage("Errore campo obbligatorio mancante, riprovare");
  }

  @Test
  public void ModificaJobTest3() throws CustomException {
    JobDto jobDto = mapperDto();
    jobDto.setCodCliente(null);
    jobDto.setCodTipoJob(null);
    Mockito.when(jobRepository.existsById(jobDto.getCodJob())).thenReturn(true);
    Mockito.when(jobMapper.toEntity(jobDto)).thenReturn(mapperEntity());
    List<JobDto> jobs = asList(jobDto);
    assertThatThrownBy(()->jobService.modificaJob(jobs)).isInstanceOf(CustomException.class).hasMessage("Attenzione!!! campi non correttamente valorizzati. Salvataggio non eseguito");
  }


  @Test
  public void ControlloChiusuraJobTest1() throws CustomException {
    JobEntity jobEntity = recuperoJob("AADD21001");

    Mockito.when(jobRepository.recuperoJob("AADD21001")).thenReturn(jobEntity);
    Mockito.when(jobMapper.toDto(jobEntity)).thenReturn(mapperDto());
    Mockito.when(jobMapper.toEntity(any(JobDto.class))).thenReturn(mapperEntity());

    jobService.controlloChiusuraJob("AADD21001");

    Mockito.verify(jobRepository).save(jobEntity);
  }

  @Test
  public void ControlloChiusuraJobTest2() throws CustomException {
    JobEntity jobEntity = recuperoJob("AADD21001");
    JobEntity jobEntity2 = recuperoJob("AADD21001");
    jobEntity.setCodStatoJob("A");
    Mockito.when(jobRepository.recuperoJob("AADD21001")).thenReturn(jobEntity);
    Mockito.when(jobMapper.toDto(jobEntity)).thenReturn(mapperDto());
    Mockito.when(jobMapper.toEntity(any(JobDto.class))).thenReturn(mapperEntity());

    jobService.controlloChiusuraJob("AADD21001");

    Mockito.verify(jobRepository).save(jobEntity2);
  }

  @Test
  public void RecuperoDettagliJobTest() throws CustomException {
    JobDto dto = mapperDto();
    JobEntity jobEntity = recuperoJob("AADD21001");
    Mockito.when(jobRepository.recuperoDettagliJob("AACQ6001", "ADV"))
        .thenReturn(ottieniDettagli());
    Mockito.when(jobMapper.toDto(jobEntity)).thenReturn(dto);

    JobDto result = jobService.recuperoDettaglioJob("AACQ6001", "ADV");

    Assert.assertNotNull(result);
    Assert.assertEquals(dto, result);
  }

  private JobEntity ottieniDettagli() {
    return new JobEntity(
        "AADD13009",
        "Fatturazione",
        "Fatturazione",
        "0",
        "ADV",
        "ADV",
        "domenicm",
        new BigDecimal(0.0000),
        "",
        "S",
        "20110101",
        "C",
        new BigDecimal(0.0000),
        new BigDecimal(0.0000),
        new BigDecimal(0.0000),
        new BigDecimal(0.0000),
        new BigDecimal(0.0000),
        new BigDecimal(0.0000),
        new BigDecimal(0.0000),
        new BigDecimal(0.0000),
        new BigDecimal(0.0000),
        "",
        "N",
        "",
        "00010101",
        "0",
        "00010101",
        "Nessuno",
        "Nessuno",
        "Nessuno",
        "N",
        new BigDecimal(0.0000),
        "Nessuna",
        "00010101",
        new BigDecimal(0.0000),
        "N",
        "N",
        "N",
        "N",
        "N",
        "O",
        "S",
        "N");
  }

  private JobEntity recuperoJob(String codJob) {
    return new JobEntity(
        "AADD13009",
        "Fatturazione",
        "Fatturazione",
        "0",
        "ADV",
        "ADV",
        "domenicm",
        new BigDecimal(0.0000),
        "",
        "S",
        "20110101",
        "C",
        new BigDecimal(0.0000),
        new BigDecimal(0.0000),
        new BigDecimal(0.0000),
        new BigDecimal(0.0000),
        new BigDecimal(0.0000),
        new BigDecimal(0.0000),
        new BigDecimal(0.0000),
        new BigDecimal(0.0000),
        new BigDecimal(0.0000),
        "",
        "N",
        "",
        "00010101",
        "0",
        "00010101",
        "Nessuno",
        "Nessuno",
        "Nessuno",
        "N",
        new BigDecimal(0.0000),
        "Nessuna",
        "00010101",
        new BigDecimal(0.0000),
        "N",
        "N",
        "N",
        "N",
        "N",
        "O",
        "S",
        "N");
  }

  private JobDto mapperDto() {
    return new JobDto(
        "AADD13009",
        "Fatturazione",
        "Fatturazione",
        "0",
        "ADV",
        "ADV",
        "domenicm",
        new BigDecimal(0.0000),
        "",
        "S",
        "20110101",
        "C",
        new BigDecimal(0.0000),
        new BigDecimal(0.0000),
        new BigDecimal(0.0000),
        new BigDecimal(0.0000),
        new BigDecimal(0.0000),
        new BigDecimal(0.0000),
        new BigDecimal(0.0000),
        new BigDecimal(0.0000),
        new BigDecimal(0.0000),
        "",
        "N",
        "",
        "00010101",
        "0",
        "00010101",
        "Nessuno",
        "Nessuno",
        "Nessuno",
        "N",
        new BigDecimal(0.0000),
        "Nessuna",
        "00010101",
        new BigDecimal(0.0000),
        "N",
        "N",
        "N",
        "N",
        "N",
        "O",
        "S",
        "N");
  }

  private JobStatoEntity mapperStatoDto(){
    return new JobStatoEntity("A","Aperto");
  }

  private JobTipoEntity mapperTipoDto(){
    return new JobTipoEntity("C","Consulenza","N","N","");
  }
  public List<JobTipoEntity> ottieniTipoJob() {
    return asList(new JobTipoEntity("C","Consulenza","N","N",""), new JobTipoEntity("P","Progetto","N","N","B"));
  }

  public List<JobStatoEntity> ottieniStatiJob() {
    return asList(new JobStatoEntity("A","Aperto"),new JobStatoEntity("C","Chiuso"),new JobStatoEntity("N","Non accettabile"));
  }

  private boolean existsById() {
    return true;
  }

  private JobEntity mapperModifica() {
    return new JobEntity(
        "AADD13009",
        "Fatturazione",
        "Fatturazione",
        "0",
        "ADV",
        "ADV",
        "domenicm",
        new BigDecimal(0.0000),
        "",
        "S",
        "20110101",
        "C",
        new BigDecimal(0.0000),
        new BigDecimal(0.0000),
        new BigDecimal(0.0000),
        new BigDecimal(0.0000),
        new BigDecimal(0.0000),
        new BigDecimal(0.0000),
        new BigDecimal(0.0000),
        new BigDecimal(0.0000),
        new BigDecimal(0.0000),
        "",
        "N",
        "",
        "00010101",
        "0",
        "00010101",
        "Nessuno",
        "Nessuno",
        "Nessuno",
        "N",
        new BigDecimal(0.0000),
        "Nessuna",
        "00010101",
        new BigDecimal(0.0000),
        "N",
        "N",
        "N",
        "N",
        "N",
        "O",
        "S",
        "N");
  }

  private JobEntity mapperEntity() {
    return new JobEntity(
        "AADD13009",
        "Fatturazione",
        "Fatturazione",
        "0",
        "ADV",
        "ADV",
        "domenicm",
        new BigDecimal(0.0000),
        "",
        "S",
        "20110101",
        "C",
        new BigDecimal(0.0000),
        new BigDecimal(0.0000),
        new BigDecimal(0.0000),
        new BigDecimal(0.0000),
        new BigDecimal(0.0000),
        new BigDecimal(0.0000),
        new BigDecimal(0.0000),
        new BigDecimal(0.0000),
        new BigDecimal(0.0000),
        "",
        "N",
        "",
        "00010101",
        "0",
        "00010101",
        "Nessuno",
        "Nessuno",
        "Nessuno",
        "N",
        new BigDecimal(0.0000),
        "Nessuna",
        "00010101",
        new BigDecimal(0.0000),
        "N",
        "N",
        "N",
        "N",
        "N",
        "O",
        "S",
        "N");
  }
}
