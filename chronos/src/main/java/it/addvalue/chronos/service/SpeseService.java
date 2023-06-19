package it.addvalue.chronos.service;

import java.util.List;
import java.util.Optional;

import it.addvalue.chronos.model.entity.SpeseEntity;
import it.addvalue.chronos.repository.SpeseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SpeseService{
    private static final String TABLE_NAME = "TB_SPESE";
    protected static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired protected SpeseRepository repository;

    public List<SpeseEntity> recuperoSpeseGiorno(int anno, int mese, int giorno, String codUtente) {
        logger.debug("The method findAll has been invoked for the table {}", TABLE_NAME);
        return repository.recuperoSpeseGiorno(anno,  mese,  giorno, codUtente);
    }

    public List<SpeseEntity> recuperoSpeseMese(int anno, int mese, String codUtente) {
        logger.debug("The method findAll has been invoked for the table {}", TABLE_NAME);
        return repository.recuperoSpeseMese(anno,  mese, codUtente);
    }


}
