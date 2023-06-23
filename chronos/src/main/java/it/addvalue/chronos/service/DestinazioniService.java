package it.addvalue.chronos.service;

import it.addvalue.chronos.core.exception.Custom;
import it.addvalue.chronos.model.dto.DestinazioniDto;
import it.addvalue.chronos.model.entity.DestinazioniEntity;
import it.addvalue.chronos.model.entity.SpeseEntity;
import it.addvalue.chronos.model.mapper.SpesaDtoSpeseEntityMapper;
import it.addvalue.chronos.repository.DestinazioniRepository;
import it.addvalue.chronos.repository.SpeseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class DestinazioniService {
    private static final String TABLE_NAME = "TB_DEST_VIAGGIO";
    protected static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    protected DestinazioniRepository repository;
    @Autowired
    protected DestinazioniDto mapper;

    public ArrayList<DestinazioniEntity> recuperoDestinazioni() {
        return repository.recuperoDestinazioni();
    }
}