package it.addvalue.chronos.service;

import it.addvalue.chronos.core.exception.EsecuzioneErrataException;
import it.addvalue.chronos.model.dto.carichiDTO;
import it.addvalue.chronos.model.entity.CarichiEntity;
import it.addvalue.chronos.model.entity.User;
import it.addvalue.chronos.model.mapper.CarichiDTOEntityMapper;
import it.addvalue.chronos.repository.CarichiRepository;
import lombok.Setter;
import lombok.AllArgsConstructor;
import it.addvalue.chronos.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarichiService {
    @Autowired private CarichiRepository caricoRepository;
    @Autowired private CarichiDTOEntityMapper caricoEM;

    @Autowired
    public CarichiService(CarichiRepository caricoRepository, CarichiDTOEntityMapper caricoEM) {
        this.caricoRepository = caricoRepository;
        this.caricoEM = caricoEM;
    }
    public void modificaElencoCarichi(List<carichiDTO> carichiDTO) throws EsecuzioneErrataException {
        List<CarichiEntity> lce = caricoEM.toEntities(carichiDTO);
        for (CarichiEntity ce : lce) {
            Optional<CarichiEntity> change = caricoRepository.findById(ce.getIdCarico());
            if (change.isPresent()) {
                caricoRepository.save(change.get());
            } else {
                throw new EsecuzioneErrataException("Errore: campo null");
            }
        }
    }
    public List<carichiDTO> getElencoCarichiGiorno(int anno, int mese, Integer giorno, String codiceUtente) {
    if (giorno == null) {
      // Recupera tutti i carichi del mese
      return getElencoCarichiMese(anno, mese, codiceUtente);
    } else {
      // Recupera i carichi del giorno specificato
      List<CarichiEntity> carichi = carichiRepository.queryCarichiGiorno(anno, mese, giorno, codiceUtente);
      return mapToCarichiDto(carichi);
    }
  }

  public List<carichiDTO> getElencoCarichiMese(int anno, int mese, String codiceUtente) {
    List<CarichiEntity> carichi = carichiRepository.queryCarichiMese(anno, mese, codiceUtente);
    return mapToCarichiDto(carichi);
  }

  // parte 4.1.1
  public boolean getStatoMese(int anno, int mese, String codiceUtente, String stato) {
    List<CarichiEntity> statoMeseList =
        carichiRepository.queryStatoMese(anno, mese, codiceUtente, stato);
    return !statoMeseList.isEmpty();
  }

  public boolean delete(List<carichiDTO> carichiDtoList) throws EsecuzioneErrataException {
    List<CarichiEntity> carichiEntities = mapToCarichiEntity(carichiDtoList);
    for (CarichiEntity carico : carichiEntities) {
      int auto;
      Optional<List<User>> utente = this.userRepository.findByUserCode(carico.getCodUtente());
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

    public boolean salvataggio(List<carichiDTO> carichiToSave) throws EsecuzioneErrataException {
        List<CarichiEntity> carichiEntities = mapToCarichiEntity(carichiToSave);
        List<CarichiEntity> carichiDaSalvare = null;
        int oreTot =0;
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

    public boolean isValido()
}
