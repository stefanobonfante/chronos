package it.addvalue.chronos.service;

import it.addvalue.chronos.model.dto.clientiDTO;
import it.addvalue.chronos.model.entity.ClientiEntity;
import it.addvalue.chronos.model.mapper.ClientiMapper;
import it.addvalue.chronos.repository.ClientiRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ClientiService {

    @Autowired private ClientiRepository clientiRepository;

    @Autowired
    protected ClientiMapper mapper;

    public List<clientiDTO> recuperaClienti(){
        List<ClientiEntity> clienti = clientiRepository.queryRecuperoClienti();
        return mapper.toDtos(clienti);

    }
}
