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
@RequestMapping("/api")
public class CarichiController {

  @Autowired CarichiService servizio;

  @GetMapping("/carichi/{year}/{month}/{day}/{usercode}")
  public ResponseEntity<List<carichiDTO>> carichi(
      @RequestParam(name = "year", required = true, defaultValue = "yearNotSpecified") int year,
      @RequestParam(name = "month", required = true, defaultValue = "monthNotSpecified") int month,
      @RequestParam(name = "day", required = false, defaultValue = "dayNotSpecified") Integer day,
      @RequestParam(name = "usercode", required = true, defaultValue = "usercodeNotSpecified")
          String usercode)
      throws EsecuzioneErrataException {
    return ResponseEntity.ok(servizio.getElencoCarichiGiorno(year, month, day, usercode));
  }

  // metodo per eliminare nel controller

  @DeleteMapping
  public ResponseEntity<Boolean> delete(List<carichiDTO> eliminazione)
      throws EsecuzioneErrataException {
    return ResponseEntity.ok(servizio.delete(eliminazione));
  }
}
