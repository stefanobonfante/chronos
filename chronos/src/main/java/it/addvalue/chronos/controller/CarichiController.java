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
<<<<<<< HEAD
      @RequestParam(name = "day", required = false) Integer day,
=======
      @RequestParam(name = "day", required = false) String day,
>>>>>>> dde552215286bd1fc37d7dded81f0ca24ef7e45a
      @RequestParam(name = "usercode", required = true) String usercode)
      throws EsecuzioneErrataException {
    return ResponseEntity.ok(servizio.getElencoCarichiGiorno(year, month, day, usercode));
  }
  // metodo per eliminare nel controller

<<<<<<< HEAD
  @GetMapping()
=======
  @GetMapping
>>>>>>> dde552215286bd1fc37d7dded81f0ca24ef7e45a
  public List<carichiDTO> getElencoCarichi(
      @RequestParam("anno") int anno,
      @RequestParam("mese") int mese,
      @RequestParam("codiceUtente") String codiceUtente,
<<<<<<< HEAD
      @RequestParam(value = "giorno", required = false) Integer giorno) {
    if (giorno != null) {
      return servizio.getElencoCarichiGiorno(anno, mese, giorno, codiceUtente);
    } else {
      return servizio.getElencoCarichiMese(anno, mese, codiceUtente);
    }
  }

  @PostMapping
  public ResponseEntity<Boolean> save(List<carichiDTO> eliminazione)
=======
      @RequestParam(value = "giorno") String giorno) {

    return servizio.getElencoCarichiGiorno(anno, mese, giorno, codiceUtente);
  }

  @PutMapping
  public ResponseEntity<Boolean> modificaCarico(@RequestBody List<carichiDTO> modifiche)
      throws EsecuzioneErrataException {
    return ResponseEntity.ok(servizio.modificaElencoCarichi(modifiche));
  }

  @PostMapping
  public ResponseEntity<Boolean> save(@RequestBody List<carichiDTO> eliminazione)
>>>>>>> dde552215286bd1fc37d7dded81f0ca24ef7e45a
      throws EsecuzioneErrataException {
    return ResponseEntity.ok(servizio.salvataggio(eliminazione));
  }

<<<<<<< HEAD
  @GetMapping("/stato-mesi/verifica-stato")
  public boolean StatoMese(String statoMese, int anno, int mese, String codiceUtente) {
    return servizio.getStatoMese(anno, mese, codiceUtente, statoMese);
  }

  @PutMapping
  public ResponseEntity<Boolean> modificaCarichi(List<carichiDTO> CarichiDTO)
      throws EsecuzioneErrataException {
    return ResponseEntity.ok(servizio.modificaElencoCarichi(CarichiDTO));
  }

=======
>>>>>>> dde552215286bd1fc37d7dded81f0ca24ef7e45a
  @DeleteMapping
  public ResponseEntity<Boolean> delete(@RequestBody List<carichiDTO> eliminazione)
      throws EsecuzioneErrataException {
    return ResponseEntity.ok(servizio.delete(eliminazione));
  }
}
