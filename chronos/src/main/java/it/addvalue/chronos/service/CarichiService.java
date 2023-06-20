package it.addvalue.chronos.service;

import it.addvalue.chronos.core.exception.EsecuzioneErrataException;
import it.addvalue.chronos.model.dto.carichiDTO;
import it.addvalue.chronos.model.entity.CarichiEntity;
import it.addvalue.chronos.model.mapper.CarichiDTOEntityMapper;
import it.addvalue.chronos.repository.CarichiRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CarichiService {

    private CarichiRepository carichiRepository;

    public List<carichiDTO> getElencoCarichiGiorno(int anno, int mese, Integer giorno, String codiceUtente) {
        if (giorno == null) {
            // Recupera tutti i carichi del mese
            return getElencoCarichiMese(anno, mese, codiceUtente);
        } else {
            // Recupera i carichi del giorno specificato
            List<CarichiEntity> carichi = carichiRepository.findByAnnoAndMeseAndGiornoAndCodUtenteOrderByAnnoAscMeseAscGiornoAscCodJobAsc(anno, mese, giorno, codiceUtente);
            return mapToCarichiDto(carichi);
        }
    }

    public List<carichiDTO> getElencoCarichiMese(int anno, int mese, String codiceUtente) {
        List<CarichiEntity> carichi = carichiRepository.findByAnnoAndMeseAndCodUtenteOrderByAnnoAscMeseAscGiornoAscCodJobAsc(anno, mese, codiceUtente);
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

    private List<carichiDTO> mapToCarichiDto(List<CarichiEntity> carichiEntities) {
        return carichiEntities.stream()
                .map(this::mapToCaricoDto)
                .collect(Collectors.toList());
    }

    private carichiDTO mapToCaricoDto(CarichiEntity carichiEntity) {
        carichiDTO dto = new carichiDTO();
        dto.setIdCarico(carichiEntity.getIdCarico());
        dto.setAnno(carichiEntity.getAnno());
        dto.setMese(carichiEntity.getMese());
        dto.setGiorno(carichiEntity.getGiorno());
        dto.setcodUtente(carichiEntity.getcodUtente());
        dto.setCodJob(carichiEntity.getCodJob());
        // Mappa altri campi...
        return dto;
    }

    private List<CarichiEntity> mapToCarichiEntity(List<carichiDTO> carichiDtoList) {
        return carichiDtoList.stream()
                .map(this::mapToCaricoEntity)
                .collect(Collectors.toList());
    }

    private CarichiEntity mapToCaricoEntity(carichiDTO carichiDTO) {
        CarichiEntity entity = new CarichiEntity();
        entity.setIdCarico(carichiDTO.getIdCarico());
        entity.setAnno(carichiDTO.getAnno());
        entity.setMese(carichiDTO.getMese());
        entity.setGiorno(carichiDTO.getGiorno());
        entity.setcodUtente(carichiDTO.getcodUtente());
        entity.setCodJob(carichiDTO.getCodJob());
        // Mappa altri campi...
        return entity;
    }
}
