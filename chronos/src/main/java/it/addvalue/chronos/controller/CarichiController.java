package it.addvalue.chronos.controller;

import it.addvalue.chronos.core.exception.EsecuzioneErrataException;
import it.addvalue.chronos.model.dto.carichiDTO;
import it.addvalue.chronos.service.CarichiService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CarichiController {

    private final CarichiService servizio;


    @RequestMapping("/api/carichi")
    public class CarichiController {
        @Autowired
        CarichiService servizio;


        @GetMapping("/{year}/{month}/{day}/{usercode}")
        public CarichiService carichi(@RequestParam(name = "year", required = true, defaultValue = "yearNotSpecified") String year,
                                      @RequestParam(name = "month", required = true, defaultValue = "monthNotSpecified") String month,
                                      @RequestParam(name = "day", required = false, defaultValue = "dayNotSpecified") String day,
                                      @RequestParam(name = "usercode", required = true, defaultValue = "usercodeNotSpecified") String usercode) throws EsecuzioneErrataException {
            servizio.getDailyCarichi();
            return servizio;
        }



    //metodo per eliminare nel controller

    @DeleteMapping
    public ResponseEntity<Boolean> delete(List<carichiDTO> eliminazione) throws EsecuzioneErrataException {
        return ResponseEntity.ok(servizio.delete(eliminazione));
    }
}