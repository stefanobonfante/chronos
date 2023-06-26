package it.addvalue.chronos.service;

import it.addvalue.chronos.model.dto.clientiDTO;
import it.addvalue.chronos.model.entity.ClientiEntity;
import it.addvalue.chronos.model.mapper.ClientiMapper;
import it.addvalue.chronos.repository.ClientiRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class ClientiService {

  @Autowired private ClientiRepository clientiRepository;

  @Autowired protected ClientiMapper mapper;

  public List<clientiDTO> recuperaClienti() {
    List<ClientiEntity> clientiEntity = clientiRepository.queryRecuperoClienti();
    ArrayList<clientiDTO> clientiDto = new ArrayList<>();
    clientiEntity.forEach(cliente -> clientiDto.add(mapper.toDtosRidotto(cliente)));
    return clientiDto;
  }
}
