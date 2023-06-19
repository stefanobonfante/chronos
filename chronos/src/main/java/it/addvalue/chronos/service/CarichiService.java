package it.addvalue.chronos.service;

import it.addvalue.chronos.core.exception.EsecuzioneErrataException;
import it.addvalue.chronos.model.dto.carichiDTO;
import it.addvalue.chronos.model.entity.CarichiEntity;
import it.addvalue.chronos.repository.CarichiRepository;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;

@NoArgsConstructor
public class CarichiService {

    CarichiRepository repoUno;

    //metodo per eliminare elementi da una tabella

    public boolean delete(ArrayList<carichiDTO> c) throws EsecuzioneErrataException {
        for(carichiDTO car:c){
            Month meseCarico=Month.of(car.getMese());
            if(meseCarico.equals(Month.now())/*&& */){ // condizione da completare
                //repoUno.delete(car);
                System.out.println("sdfghjkl");
            }else if(car==null){
                throw new EsecuzioneErrataException("oggetto non trovato.");
            }else{
                throw new EsecuzioneErrataException("impossibile eseguire l'operazione.");
            }
        }
        return true;
    }
}
