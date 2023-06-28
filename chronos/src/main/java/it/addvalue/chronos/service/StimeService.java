package it.addvalue.chronos.service;

import it.addvalue.chronos.model.entity.StimeEntity;
import it.addvalue.chronos.model.entity.StimeProjection;
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

  public List<StimeProjection> recuperoTask(String cod_job) {
    List<StimeEntity> listaStime = stimeRrepository.getStime(cod_job);
    List<StimeProjection> listaDTO = new ArrayList<>();
    listaStime.stream().forEach(x -> listaDTO.add(stimeMapper.toProjection(x)));
    return listaDTO;
  }
}
