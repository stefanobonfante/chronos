package it.addvalue.chronos.service;

import it.addvalue.chronos.model.entity.DestinazioniEntity;
import it.addvalue.chronos.model.mapper.DestinazioniDtoDestinazioniEntityMapper;
import it.addvalue.chronos.repository.DestinazioniRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinazioniService {
    private static final String TABLE_NAME = "TB_DEST_VIAGGIO";
    protected static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    protected DestinazioniRepository repository;
    @Autowired
    protected DestinazioniDtoDestinazioniEntityMapper mapper;

    public List<DestinazioniEntity> recuperoDestinazioni() {
        return repository.findAll();
    }
}