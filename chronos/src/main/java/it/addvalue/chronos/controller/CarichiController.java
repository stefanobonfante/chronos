package it.addvalue.chronos.controller;

import it.addvalue.chronos.core.exception.EsecuzioneErrataException;
import it.addvalue.chronos.model.dto.carichiDTO;
import it.addvalue.chronos.service.CarichiService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CarichiController {

    private final CarichiService servizio;



    //metodo per eliminare nel controller

    @DeleteMapping
    public ResponseEntity<Boolean> delete(List<carichiDTO> eliminazione) throws EsecuzioneErrataException {
        return ResponseEntity.ok(servizio.delete(eliminazione));
    }
}
