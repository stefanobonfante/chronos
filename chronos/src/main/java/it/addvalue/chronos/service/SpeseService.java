package it.addvalue.chronos.service;

import it.addvalue.chronos.core.exception.Custom;
import it.addvalue.chronos.model.dto.SpeseDto;
import it.addvalue.chronos.model.entity.SpeseEntity;
import it.addvalue.chronos.model.mapper.SpesaDtoSpeseEntityMapper;
import it.addvalue.chronos.repository.SpeseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class SpeseService {
    private static final String TABLE_NAME = "TB_SPESE";
    protected static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    protected SpeseRepository repository;

    @Autowired
    protected SpesaDtoSpeseEntityMapper mapper;

    public ArrayList<SpeseEntity> recuperoSpeseGiorno(int anno, int mese, int giorno, String codUtente) {
        logger.debug("The method findAll has been invoked for the table {}", TABLE_NAME);
        return repository.recuperoSpeseGiorno(anno, mese, giorno, codUtente);
    }

    public ArrayList<SpeseEntity> recuperoSpeseMese(int anno, int mese, String codUtente) {
        logger.debug("The method findAll has been invoked for the table {}", TABLE_NAME);
        return repository.recuperoSpeseMese(anno, mese, codUtente);
    }

    public void deleatElementi(List<SpeseEntity> spese) {
        for (SpeseEntity spesa : spese) {
            if (spesa.getMese() == LocalDate.now().getMonthValue()) {
                repository.RecuperoSpesaDaEliminare(spesa.getIdSpese());
            }
        }
    }

    public void filtroSpese(List<SpeseDto> spese) throws Custom {
        for (SpeseDto spesa : spese) {
            if (repository.existsById((spesa.getIdSpese()))) {
                modificaSpese(spesa);
            } else {
                salvataggioSpese(spesa);
            }
        }
    }

    public void salvataggioSpese(SpeseDto spesa) throws Custom {
        logger.debug("The method findAll has been invoked for the table {}", TABLE_NAME);
        boolean flag;

        flag = false;
        if (spesa.getMese() == LocalDate.now().getMonthValue() && spesa.getAnno() != 0 && spesa.getMese() != 0 && spesa.getGiorno() != 0 && spesa.getCodUtente() != null && !spesa.getCodUtente().equals("") && spesa.getCodJob() != null && !spesa.getCodJob().equals("")) {

            for (SpeseEntity elemento : repository.findAll()) {
                if (elemento.equals(spesa.getCodJob())) {
                    flag = true;
                }
            }
            if (!flag) {
                logger.warn("Il job non è presente nell'elenco dei carichi dell'utente");
            }
            if (!calcoloOre(spesa)) {
                logger.warn("Totale ore di viaggio non corretto");
            }
            repository.save(mapper.toEntity(spesa));
        } else {
            throw new Custom("Errore nel salvataggio dela spesa");
        }
    }

    public void modificaSpese(SpeseDto spesa) throws Custom {
        logger.debug("The method findAll has been invoked for the table {}", TABLE_NAME);
        boolean flag;
        flag = false;
        if (spesa.getMese() == LocalDate.now().getMonthValue() && spesa.getAnno() != 0 && spesa.getMese() != 0 && spesa.getGiorno() != 0 && spesa.getCodUtente() != null && !spesa.getCodUtente().equals("") && spesa.getCodJob() != null && !spesa.getCodJob().equals("")) {
            for (SpeseEntity elemento : repository.findAll()) {
                if (elemento.equals(spesa.getCodJob())) {
                    flag = true;
                }
            }
            if (!flag) {
                logger.warn("1. Il job non è presente nell'elenco dei carichi dell'utente");
            }
            if (!calcoloOre(spesa)) {
                logger.warn("Totale ore di viaggio non corretto");
            }
            SpeseEntity modifica = mapper.toEntity(spesa);
            repository.save(modifica);


        } else {
            throw new Custom("Errore nel salvataggio dela spesa");
        }
    }

    public boolean calcoloOre(SpeseDto spesa) {
        BigDecimal divisore = new BigDecimal("0.25");
        BigDecimal dividendo = spesa.getTotOreViaggio();
        BigDecimal resto = dividendo.remainder(divisore);
        BigDecimal corretto = new BigDecimal("0.00");
        if (!resto.equals(corretto)) {
            return false;
        }
        return true;
    }
}