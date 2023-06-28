package it.addvalue.chronos.service;

import it.addvalue.chronos.core.exception.EsecuzioneErrataException;
import it.addvalue.chronos.model.dto.carichiDTO;
import it.addvalue.chronos.model.entity.CarichiEntity;
import it.addvalue.chronos.model.mapper.CarichiDTOEntityMapper;
import it.addvalue.chronos.repository.CarichiRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class CarichiService {
    private final CarichiRepository caricoRepository;
    private CarichiDTOEntityMapper caricoEM;

    @Autowired
    public CarichiService(CarichiRepository caricoRepository, CarichiDTOEntityMapper caricoEM) {
        this.caricoRepository = caricoRepository;
        this.caricoEM = caricoEM;
    }
    public void modificaElencoCarichi(List<carichiDTO> carichiDTO) throws EsecuzioneErrataException {
        List<CarichiEntity> lce = caricoEM.toEntities(carichiDTO);
        for (CarichiEntity ce : lce) {
            Optional<CarichiEntity> change = caricoRepository.findById(ce.getIdCarico());
            if(change.isPresent()){
                caricoRepository.save(change.get());
            }else{
                throw new EsecuzioneErrataException("Errore: campo null");
            }
        }
    }

    public boolean isValido()
}
