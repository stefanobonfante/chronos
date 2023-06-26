package it.addvalue.chronos.service;

import it.addvalue.chronos.core.exception.EsecuzioneErrataException;
import it.addvalue.chronos.model.dto.carichiDTO;
import it.addvalue.chronos.model.entity.CarichiEntity;
import it.addvalue.chronos.model.entity.User;
import it.addvalue.chronos.model.mapper.CarichiDTOEntityMapper;
import it.addvalue.chronos.repository.CarichiRepository;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import it.addvalue.chronos.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class CarichiService {
  @Autowired private CarichiRepository caricoRepository;
  @Autowired private CarichiDTOEntityMapper caricoEM;
  @Autowired private IUserRepository userRepository;

  public boolean modificaElencoCarichi(List<carichiDTO> carichiDTO)
      throws EsecuzioneErrataException {
    List<CarichiEntity> lce = caricoEM.toEntities(carichiDTO);
    for (CarichiEntity ce : lce) {
      Optional<CarichiEntity> change = caricoRepository.findById(ce.getIdCarico());
      if (change.isPresent()) {
        if (isVerificato(change.get())) {
          caricoRepository.save(change.get());
        } else {
          throw new EsecuzioneErrataException("Errore: campo null");
        }
      } else {
        throw new EsecuzioneErrataException("Errore: campo null");
      }
    }
    return true;
  }

  public List<carichiDTO> getElencoCarichiGiorno(
      int anno, int mese, Integer giorno, String codiceUtente) {
    if (giorno == null) {
      // Recupera tutti i carichi del mese
      return getElencoCarichiMese(anno, mese, codiceUtente);
    } else {
      // Recupera i carichi del giorno specificato
      List<CarichiEntity> carichi =
          caricoRepository.queryCarichiGiorno(anno, mese, giorno, codiceUtente);
      return caricoEM.toDtos(carichi);
    }
  }

  public List<carichiDTO> getElencoCarichiMese(int anno, int mese, String codiceUtente) {
    List<CarichiEntity> carichi = caricoRepository.queryCarichiMese(anno, mese, codiceUtente);
    return caricoEM.toDtos(carichi);
  }

  // parte 4.1.1

  public boolean getStatoMese(int anno, int mese, String codiceUtente, String stato) {
    List<CarichiEntity> statoMeseList =
        caricoRepository.queryStatoMese(anno, mese, codiceUtente, stato);
    return !statoMeseList.isEmpty();
  }

  public boolean delete(List<carichiDTO> carichiDtoList) throws EsecuzioneErrataException {
    List<CarichiEntity> carichiEntities = caricoEM.toEntities(carichiDtoList);
    for (CarichiEntity carico : carichiEntities) {
      int auto;
      Optional<List<User>> utente = this.userRepository.findByUserCode(carico.getCodUtente());
      if (utente.isPresent()) {
        auto = utente.get().get(0).getLevel();
      } else {
        auto = 10;
      }
      if (carico.getMese() == LocalDate.now().getMonthValue() || auto <= 3) {
        caricoRepository.delete(carico);
      } else {
        throw new EsecuzioneErrataException("Impossibile eseguire l'operazione.");
      }
    }
    return true;
  }

  public boolean salvataggio(List<carichiDTO> carichiToSave) throws EsecuzioneErrataException {
    List<CarichiEntity> carichiEntities = caricoEM.toEntities(carichiToSave);
    List<CarichiEntity> carichiDaSalvare = null;
    int oreTot = 0;
    for (CarichiEntity carico : carichiEntities) {
      if (isVerificato(carico)) {
        carichiDaSalvare.add(carico);
        oreTot += carico.getOre();
      } else {
        throw new EsecuzioneErrataException("Impossibile eseguire l'operazione.");
      }
    }
    return true;
  }

  private boolean isVerificato(CarichiEntity carico) throws EsecuzioneErrataException {
    Optional<ArrayList<User>> utente = caricoRepository.getUtente(carico.getCodUtente());
    String[] ore = carico.getOraInizioStr().split(":");
    if (utente.isPresent()) {
      int livelloUtente = utente.get().get(0).getLevel();
    } else {
      throw new EsecuzioneErrataException("Impossibile eseguire l'operazione.");
    }
    if (!(carico.getCodJob().isEmpty()
            && carico.getCodTask().isEmpty()
            && carico.getCodSTask().isEmpty()
            && carico.getCodAttivita().isEmpty())
        && carico.getAnno() > 1990
        && carico.getMese() >= 1
        && carico.getMese() <= 12
        && carico.getGiorno() >= 1
        && carico.getGiorno() <= 31
        && carico.getOre() >= 1
        && carico.getOre() <= 24) {
      if (carico.getFlgStr().equals("S")) {
        if (LocalDate.of(carico.getAnno(), carico.getMese(), carico.getGiorno())
                    .getDayOfWeek()
                    .getValue()
                == 6
            || LocalDate.of(carico.getAnno(), carico.getMese(), carico.getGiorno())
                    .getDayOfWeek()
                    .getValue()
                == 7) {
          if (Integer.parseInt(ore[0]) <= 0 || Integer.parseInt(ore[0]) >= 24) {
            throw new EsecuzioneErrataException("ore straordinario errate");
          }
        } else {
          if (Integer.parseInt(ore[0]) > 9 && Integer.parseInt(ore[0]) < 18
              || Integer.parseInt(ore[0]) <= 0 && Integer.parseInt(ore[0]) <= 24) {
            throw new EsecuzioneErrataException("ore straordinario errate");
          }
        }
      } else if (carico.getFlgStr().equals("N")) {
        if (Integer.parseInt(ore[0]) <= 0 || Integer.parseInt(ore[0]) >= 24) {
          throw new EsecuzioneErrataException("ore errate");
        }
      }
    }
    return true;
  }
}
