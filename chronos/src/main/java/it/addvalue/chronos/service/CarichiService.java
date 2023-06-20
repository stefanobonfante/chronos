package it.addvalue.chronos.service;

import it.addvalue.chronos.core.exception.EsecuzioneErrataException;
import it.addvalue.chronos.model.dto.carichiDTO;
import it.addvalue.chronos.model.entity.CarichiEntity;
import it.addvalue.chronos.model.mapper.CarichiDTOEntityMapper;
import it.addvalue.chronos.repository.CarichiRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@Service
public class CarichiService {

    CarichiRepository repoUno;


    public List<carichiDTO> getDailyCarichi(List<carichiDTO> c, DayOfWeek giorno) throws EsecuzioneErrataException {
        List<CarichiEntity> cE= new CarichiDTOEntityMapper().toEntities(c);
        ArrayList<carichiDTO> dailyCarichi = new ArrayList<>();
        for(CarichiEntity car:cE){
            Year annoCarico = Year.of(car.getAnno());
            Month meseCarico = Month.of(car.getMese());
            DayOfWeek giornoCarico = giorno;

            if(annoCarico.equals(LocalDate.now().getYear()) && meseCarico.equals(LocalDate.now().getMonth()) && giornoCarico.equals(LocalDate.now().getDayOfWeek())){ // condizione da completare
                dailyCarichi.add((carichiDTO) cE);
            }else if(car==null){
                throw new EsecuzioneErrataException("oggetto non trovato.");
            }else{
                throw new EsecuzioneErrataException("impossibile eseguire l'operazione.");
            }
        }
        return dailyCarichi;    }

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
