package it.addvalue.chronos.service;

import it.addvalue.chronos.core.exception.EsecuzioneErrataException;
import it.addvalue.chronos.model.dto.carichiDTO;
import it.addvalue.chronos.model.entity.CarichiEntity;
import it.addvalue.chronos.model.entity.User;
import it.addvalue.chronos.repository.CarichiRepository;
import it.addvalue.chronos.repository.IUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CarichiService {

    private CarichiRepository carichiRepository;
    @Autowired
    IUserRepository userRepository;

    public List<carichiDTO> getElencoCarichiGiorno(
            int anno, int mese, Integer giorno, String codiceUtente) {
        if (giorno == null) {
            // Recupera tutti i carichi del mese
            return getElencoCarichiMese(anno, mese, codiceUtente);
        } else {
            // Recupera i carichi del giorno specificato
            List<CarichiEntity> carichi = carichiRepository.query2(anno, mese, giorno, codiceUtente);
            return mapToCarichiDto(carichi);
        }
    }

    public List<carichiDTO> getElencoCarichiMese(int anno, int mese, String codiceUtente) {
        List<CarichiEntity> carichi = carichiRepository.getUtente(anno, mese, codiceUtente);
        return mapToCarichiDto(carichi);
    }

    public boolean delete(List<carichiDTO> carichiDtoList) throws EsecuzioneErrataException {
        List<CarichiEntity> carichiEntities = mapToCarichiEntity(carichiDtoList);
        for (CarichiEntity carico : carichiEntities) {
            if (carico.getMese() == LocalDate.now().getMonthValue()) {
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
        if (oreTot <=24){
            carichiRepository.saveAll(carichiDaSalvare);
        }
        else {
            throw new EsecuzioneErrataException("Impossibile eseguire l'operazione.");
        }
        return true;
    }

    private boolean isVerificato(CarichiEntity carico) throws EsecuzioneErrataException {
        Optional<ArrayList<User>> utente = this.carichiRepository.getUtente(carico.getCodUtente());
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
                if (LocalDate.of(carico.getAnno(), carico.getMese(), carico.getGiorno()).getDayOfWeek().getValue() == 6 || LocalDate.of(carico.getAnno(), carico.getMese(), carico.getGiorno()).getDayOfWeek().getValue() == 7) {

                    if (Integer.parseInt(ore[0]) <= 0 || Integer.parseInt(ore[0]) >= 24) {
                        throw new EsecuzioneErrataException("ore straordinario errate");
                    }

                } else {
                    if (Integer.parseInt(ore[0]) > 9 && Integer.parseInt(ore[0]) < 18 || Integer.parseInt(ore[0]) <=0 && Integer.parseInt(ore[0])<= 24) {
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

    private List<carichiDTO> mapToCarichiDto(List<CarichiEntity> carichiEntities) {
        return carichiEntities.stream().map(this::mapToCaricoDto).collect(Collectors.toList());
    }

    private carichiDTO mapToCaricoDto(CarichiEntity carichiEntity) {
        carichiDTO dto = new carichiDTO();
        dto.setIdCarico(carichiEntity.getIdCarico());
        dto.setAnno(carichiEntity.getAnno());
        dto.setMese(carichiEntity.getMese());
        dto.setGiorno(carichiEntity.getGiorno());
        dto.setCodUtente(carichiEntity.getCodUtente());
        dto.setCodJob(carichiEntity.getCodJob());
        return dto;
    }

    private List<CarichiEntity> mapToCarichiEntity(List<carichiDTO> carichiDtoList) {
        return carichiDtoList.stream().map(this::mapToCaricoEntity).collect(Collectors.toList());
    }

    private CarichiEntity mapToCaricoEntity(carichiDTO carichiDTO) {
        CarichiEntity entity = new CarichiEntity();
        entity.setIdCarico(carichiDTO.getIdCarico());
        entity.setAnno(carichiDTO.getAnno());
        entity.setMese(carichiDTO.getMese());
        entity.setGiorno(carichiDTO.getGiorno());
        entity.setCodUtente(carichiDTO.getCodUtente());
        entity.setCodJob(carichiDTO.getCodJob());
        // Mappa altri campi...
        return entity;
    }
}
