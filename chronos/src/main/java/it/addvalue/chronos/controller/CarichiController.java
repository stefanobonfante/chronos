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
@RequestMapping("/api/carichi/")
public class CarichiController {

  @Autowired CarichiService servizio;

  @GetMapping("{year}/{month}/{day}/{usercode}")
  public ResponseEntity<List<carichiDTO>> carichi(
      @RequestParam(name = "year", required = true) int year,
      @RequestParam(name = "month", required = true) int month,
      @RequestParam(name = "day", required = false) Integer day,
      @RequestParam(name = "usercode", required = true) String usercode)
      throws EsecuzioneErrataException {
    return ResponseEntity.ok(servizio.getElencoCarichiGiorno(year, month, day, usercode));
  }
  // metodo per eliminare nel controller

  @GetMapping()
  public List<carichiDTO> getElencoCarichi(
      @RequestParam("anno") int anno,
      @RequestParam("mese") int mese,
      @RequestParam("codiceUtente") String codiceUtente,
      @RequestParam(value = "giorno", required = false) Integer giorno) {
    if (giorno != null) {
      return servizio.getElencoCarichiGiorno(anno, mese, giorno, codiceUtente);
    } else {
      return servizio.getElencoCarichiMese(anno, mese, codiceUtente);
    }
  }

  @PostMapping
  public ResponseEntity<Boolean> save(@RequestBody List<carichiDTO> eliminazione)
      throws EsecuzioneErrataException {
    return ResponseEntity.ok(servizio.salvataggio(eliminazione));
  }

  @GetMapping("/stato-mesi/verifica-stato")
  public boolean StatoMese(String statoMese, int anno, int mese, String codiceUtente) {
    return servizio.getStatoMese(anno, mese, codiceUtente, statoMese);
  }

  @DeleteMapping
  public ResponseEntity<Boolean> delete(List<carichiDTO> eliminazione)
      throws EsecuzioneErrataException {
    return ResponseEntity.ok(servizio.delete(eliminazione));
  }
}
