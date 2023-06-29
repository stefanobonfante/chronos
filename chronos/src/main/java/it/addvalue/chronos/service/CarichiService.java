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
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
public class CarichiService {
  @Autowired private CarichiRepository caricoRepository;
  @Autowired private CarichiDTOEntityMapper caricoEM;
  @Autowired private IUserRepository userRepository;

  public boolean modificaElencoCarichi(List<carichiDTO> carichiDTO) // TESTATO FUNZIONA
      throws EsecuzioneErrataException {
    List<CarichiEntity> listaCarichi = caricoEM.toEntities(carichiDTO);
    for (CarichiEntity caricoAggiornato : listaCarichi) {
      Optional<CarichiEntity> change = caricoRepository.findById(caricoAggiornato.getIdCarico());
      if (change.isPresent() && isVerificato(change.get())) {
        caricoRepository.save(caricoAggiornato);
      } else {
        throw new EsecuzioneErrataException("Errore: il carico non esiste nel database");
      }
    }
    return true;
  }

  public List<carichiDTO> getElencoCarichiGiorno( // DA TESTARE
      int anno, int mese, String giorno, String codiceUtente) throws EsecuzioneErrataException {
    if (giorno == null) {
      // Recupera tutti i carichi del mese
      return getElencoCarichiMese(anno, mese, codiceUtente);
    } else {
      // Recupera i carichi del giorno specificato
      int giornoEffettivo = Integer.parseInt(giorno);
      List<CarichiEntity> carichi =
          caricoRepository.queryCarichiGiorno(anno, mese, giornoEffettivo, codiceUtente);
      return caricoEM.toDtos(carichi);
    }
  }

  public List<carichiDTO> getElencoCarichiMese(int anno, int mese, String codiceUtente)
      throws EsecuzioneErrataException { // TESTATO FUNZIONA
    List<CarichiEntity> carichi = caricoRepository.queryCarichiMese(anno, mese, codiceUtente);
    if (carichi.isEmpty()) {
      throw new EsecuzioneErrataException("non e stato trovato nessun elemento");
    } else {
      return caricoEM.toDtos(carichi);
    }
  }

  // parte 4.1.1

  public boolean getStatoMese(int anno, int mese, String codiceUtente, String stato) {
    List<CarichiEntity> statoMeseList =
        caricoRepository.queryStatoMese(anno, mese, codiceUtente, stato);
    return !statoMeseList.isEmpty();
  }

  public boolean delete(List<carichiDTO> carichiDtoList)
      throws EsecuzioneErrataException { // TESTATO FUNZIONA
    List<CarichiEntity> carichiEntities = caricoEM.toEntities(carichiDtoList);
    User utente;
    for (CarichiEntity carico : carichiEntities) {
      if (!caricoRepository.existsById(carico.getIdCarico())) {
        throw new EsecuzioneErrataException("il carico non esiste.");
      }
      utente = userRepository.findByUserCode(carico.getCodUtente());
      if (carico.getMese() == LocalDate.now().getMonthValue() || utente.getLevel() <= 3) {
        caricoRepository.delete(carico);
      } else {
        throw new EsecuzioneErrataException(
            "Impossibile eseguire l'operazione. il mese e terminato o il livello utenete non e adeguato.");
      }
    }
    return true;
  }

  public boolean salvataggio(List<carichiDTO> carichiToSave)
      throws EsecuzioneErrataException { // TESTATO FUNZIONA
    List<CarichiEntity> carichiEntities = caricoEM.toEntities(carichiToSave);
    List<CarichiEntity> carichiDaSalvare = new ArrayList<>();
    int oreTot = 0;
    for (CarichiEntity carico : carichiEntities) {
      if (isVerificato(carico)) {
        carichiDaSalvare.add(carico);
        oreTot += carico.getOre();
      }
    }

    if (oreTot <= 24) {
      caricoRepository.saveAll(carichiDaSalvare);
    } else {
      throw new EsecuzioneErrataException("Impossibile eseguire l'operazione.");
    }
    return true;
  }

  public boolean isVerificato(@NotNull CarichiEntity carico)
      throws EsecuzioneErrataException { // TESTATO FUNZIONA
    User utente = this.userRepository.findByUserCode(carico.getCodUtente());
    if ((carico.getCodJob() != null
            && carico.getCodTask() != null
            && carico.getCodAttivita() != null)
        && (!carico.getCodJob().isBlank()
            && !carico.getCodTask().isBlank()
            && !carico.getCodAttivita().isBlank()
            && carico.getAnno() > 1990
            && carico.getMese() >= 1
            && carico.getMese() <= 12
            && carico.getGiorno() >= 1
            && carico.getGiorno() <= 31
            && carico.getOre() >= 1
            && carico.getOre() <= 24
            && utente.getLevel() <= 3)) {
      if (carico.getFlgStr().equals("S")) {
        String[] ore = carico.getOraInizioStr().split(":");
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
        if (carico.getOre() > 8) {
          throw new EsecuzioneErrataException("ore errate");
        }
      } else {
        throw new EsecuzioneErrataException("flag straordinari non trovato");
      }

    } else throw new EsecuzioneErrataException("hai inserito dei campi errati");
    return true;
  }

  public boolean presenzaCarichi( int anno, int mese, int giorno, String codiceUtente, String codJob) {
    return !caricoRepository.queryPresenzaCarichi(anno, mese, giorno, codiceUtente, codJob).isEmpty();

  }
}
