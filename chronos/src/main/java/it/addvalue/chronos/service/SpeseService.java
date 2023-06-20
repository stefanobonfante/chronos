package it.addvalue.chronos.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import it.addvalue.chronos.core.exception.Custom;
import it.addvalue.chronos.model.dto.SpeseDto;
import it.addvalue.chronos.model.entity.SpeseEntity;
import it.addvalue.chronos.model.mapper.SpesaDtoSpeseEntityMapper;
import it.addvalue.chronos.repository.SpeseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpeseService {
  private static final String TABLE_NAME = "TB_SPESE";
  protected static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

  @Autowired protected SpeseRepository repository;

  @Autowired protected SpesaDtoSpeseEntityMapper mapper;

  public List<SpeseEntity> recuperoSpeseGiorno(int anno, int mese, int giorno, String codUtente) {
    logger.debug("The method findAll has been invoked for the table {}", TABLE_NAME);
    return repository.recuperoSpeseGiorno(anno, mese, giorno, codUtente);
  }

  public List<SpeseEntity> recuperoSpeseMese(int anno, int mese, String codUtente) {
    logger.debug("The method findAll has been invoked for the table {}", TABLE_NAME);
    return repository.recuperoSpeseMese(anno, mese, codUtente);
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
    if (spesa.getMese() == LocalDate.now().getMonthValue()) {
      if (spesa.getAnno() != 0) {
        if (spesa.getMese() != 0) {
          if (spesa.getGiorno() != 0) {
            if (spesa.getCodUtente() != null && !spesa.getCodUtente().equals("")) {
              if (spesa.getCodJob() != null && !spesa.getCodJob().equals("")) {
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
              }
            }
          }
        }
      }
    }
    throw new Custom("Errore nel salvataggio dela spesa");
  }

  public void modificaSpese(SpeseDto spesa) throws Custom {
    logger.debug("The method findAll has been invoked for the table {}", TABLE_NAME);
    boolean flag;
    flag = false;
    if (spesa.getMese() == LocalDate.now().getMonthValue()) {
      if (spesa.getAnno() != 0) {
        if (spesa.getMese() != 0) {
          if (spesa.getGiorno() != 0) {
            if (spesa.getCodUtente() != null && !spesa.getCodUtente().equals("")) {
              if (spesa.getCodJob() != null && !spesa.getCodJob().equals("")) {
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
                SpeseEntity modifica = new SpeseEntity();
                modifica = mapper.toEntity(spesa);
                repository.modificaDB(
                    modifica.getIdSpese(),
                    modifica.getCodUtente(),
                    modifica.getCodJob(),
                    modifica.getAnno(),
                    modifica.getMese(),
                    modifica.getGiorno(),
                    modifica.getPercorso(),
                    modifica.getKmPercorsi(),
                    modifica.getRimborsoKm(),
                    modifica.getCarburante(),
                    modifica.getPedaggi(),
                    modifica.getAltro(),
                    modifica.getAnticipi(),
                    modifica.getParcheggi(),
                    modifica.getTrasporti(),
                    modifica.getTotSpese(),
                    modifica.getTrasferta(),
                    modifica.getFlgAndata(),
                    modifica.getFlgRitorno(),
                    modifica.getTotOreViaggio(),
                    modifica.getReperibilita(),
                    modifica.getFlgAutoPf(),
                    modifica.getFlgAutoAr());
              }
            }
          }
        }
      }
    }
    throw new Custom("Errore nel salvataggio dela spesa");
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
