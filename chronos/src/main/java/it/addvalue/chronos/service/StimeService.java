package it.addvalue.chronos.service;

import it.addvalue.chronos.core.exception.EsecuzioneErrataException;
import it.addvalue.chronos.model.entity.StimeEntity;
import it.addvalue.chronos.model.entity.StimeProjection;
import it.addvalue.chronos.model.entity.StimeProjectionSubTask;
import it.addvalue.chronos.repository.StimeRrepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import it.addvalue.chronos.model.mapper.StimeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class StimeService {
  @Autowired StimeRrepository stimeRrepository;
  @Autowired StimeMapper stimeMapper;

  public List<StimeProjection> recuperoTask(String cod_job) throws EsecuzioneErrataException {
    List<StimeEntity> listaStime = stimeRrepository.getTask(cod_job);
    if(listaStime.isEmpty()){
      throw new EsecuzioneErrataException("sono stati immessi dei campi errati");
    }
    List<StimeProjection> listaDTO = new ArrayList<>();
    listaStime.stream().forEach(x -> listaDTO.add(stimeMapper.toProjection(x)));
    return listaDTO;
  }
  public List<StimeProjectionSubTask> recuperoSubTask (String cod_job, String cod_task){
    List<StimeEntity> listaStime = stimeRrepository.getSubTask(cod_job,cod_task);
    List<StimeProjectionSubTask> listaDTO = new ArrayList<>();
    listaStime.stream().forEach(x -> listaDTO.add(stimeMapper.toProjectionSubTask(x)));
    return listaDTO;
  }
}
