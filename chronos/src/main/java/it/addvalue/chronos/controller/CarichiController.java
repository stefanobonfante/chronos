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
  public CarichiService carichi(
      @RequestParam(name = "year", required = true, defaultValue = "yearNotSpecified") int year,
      @RequestParam(name = "month", required = true, defaultValue = "monthNotSpecified") int month,
      @RequestParam(name = "day", required = false, defaultValue = "dayNotSpecified") Integer day,
      @RequestParam(name = "usercode", required = true, defaultValue = "usercodeNotSpecified")
          String usercode)
      throws EsecuzioneErrataException {
    servizio.getElencoCarichiGiorno(year, month, day, usercode);
    return servizio;
  }

  // punto 2.1.2
  @RestController
  @RequestMapping("/api")
  public class GestioneMesiController {
    private CarichiService carichiService; // Riferimento al service per il recupero dei carichi

    @GetMapping("/carichi")
    public List<carichiDTO> getElencoCarichi(
        @RequestParam("anno") int anno,
        @RequestParam("mese") int mese,
        @RequestParam("codiceUtente") String codiceUtente,
        @RequestParam(value = "giorno", required = false) Integer giorno) {
      if (giorno != null) {
        return carichiService.getElencoCarichiGiorno(anno, mese, giorno, codiceUtente);
      } else {
        return carichiService.getElencoCarichiMese(anno, mese, codiceUtente);
      }
    }
  }

  @GetMapping("/stato-mesi/verifica-stato")
  public boolean StatoMese(String statoMese, int anno, int mese, String codiceUtente){
    return statoMese.equals("S");
  }

  // metodo per eliminare nel controller

  @DeleteMapping
  public ResponseEntity<Boolean> delete(List<carichiDTO> eliminazione)
      throws EsecuzioneErrataException {
    return ResponseEntity.ok(servizio.delete(eliminazione));
  }
}
