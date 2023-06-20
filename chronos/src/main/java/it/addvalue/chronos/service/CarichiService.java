package it.addvalue.chronos.service;

import it.addvalue.chronos.core.exception.EsecuzioneErrataException;
import it.addvalue.chronos.model.dto.carichiDTO;
import it.addvalue.chronos.model.entity.CarichiEntity;
import it.addvalue.chronos.model.mapper.CarichiDTOEntityMapper;
import it.addvalue.chronos.repository.CarichiRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;


@AllArgsConstructor
@Service
public class CarichiService {

    CarichiRepository repoUno;

    //metodo per eliminare elementi da una tabella

    public boolean delete(List<carichiDTO> c) throws EsecuzioneErrataException {
        List<CarichiEntity> cE= new CarichiDTOEntityMapper().toEntities(c);
        for(CarichiEntity car:cE){
            Month meseCarico=Month.of(car.getMese());
            if(meseCarico.equals(LocalDate.now().getMonth())/*&& */){ // condizione da completare
                repoUno.delete(car);
            }else if(car==null){
                throw new EsecuzioneErrataException("oggetto non trovato.");
            }else{
                throw new EsecuzioneErrataException("impossibile eseguire l'operazione.");
            }
        }
        return true;
    }
}
