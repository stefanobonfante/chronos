package it.addvalue.chronos.service;

import it.addvalue.chronos.core.exception.EsecuzioneErrataException;
import it.addvalue.chronos.model.dto.carichiDTO;
import it.addvalue.chronos.model.entity.CarichiEntity;
import it.addvalue.chronos.model.entity.User;
import it.addvalue.chronos.model.mapper.CarichiDTOEntityMapper;
import it.addvalue.chronos.repository.CarichiRepository;
import it.addvalue.chronos.repository.IUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CarichiService {

  @Autowired private IUserRepository userRepository;
  @Autowired private CarichiRepository carichiRepository;
  @Autowired protected CarichiDTOEntityMapper mapper;

  public List<carichiDTO> getElencoCarichiGiorno(
      int anno, int mese, Integer giorno, String codiceUtente) {
    if (giorno == null) {
      // Recupera tutti i carichi del mese
      return getElencoCarichiMese(anno, mese, codiceUtente);
    } else {
      // Recupera i carichi del giorno specificato
      List<CarichiEntity> carichi =
          carichiRepository.queryCarichiGiorno(anno, mese, giorno, codiceUtente);
      return mapper.toDtos(carichi);
    }
  }

  public List<carichiDTO> getElencoCarichiMese(int anno, int mese, String codiceUtente) {
    List<CarichiEntity> carichi = carichiRepository.queryCarichiMese(anno, mese, codiceUtente);
    return mapper.toDtos(carichi);
  }

  // parte 4.1.1
  public boolean getStatoMese(int anno, int mese, String codiceUtente, String stato) {
    List<CarichiEntity> statoMeseList =
        carichiRepository.queryStatoMese(anno, mese, codiceUtente, stato);
    return !statoMeseList.isEmpty();
  }

  public boolean presenzaCarichi(
      int anno, int mese, int giorno, String codiceUtente, String codJob) {
    if (carichiRepository
        .queryPresenzaCarichi(anno, mese, giorno, codiceUtente, codJob)
        .isEmpty()) {
      return false;
    } else {
      return true;
    }
  }

  public boolean delete(List<carichiDTO> carichiDtoList) throws EsecuzioneErrataException {
    List<CarichiEntity> carichiEntities = mapper.toEntities(carichiDtoList);
    for (CarichiEntity carico : carichiEntities) {
      int auto;
      Optional<List<User>> utente = this.userRepository.getLivelloUtente1(carico.getCodUtente());
      if (utente.isPresent()) {
        auto = utente.get().get(0).getLevel();
      } else {
        auto = 10;
      }
      if (carico.getMese() == LocalDate.now().getMonthValue() || auto <= 3) {
        carichiRepository.delete(carico);
      } else {
        throw new EsecuzioneErrataException("Impossibile eseguire l'operazione.");
      }
    }
    return true;
  }
}
