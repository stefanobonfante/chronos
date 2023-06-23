package it.addvalue.chronos.controller;

import it.addvalue.chronos.model.dto.carichiDTO;
import it.addvalue.chronos.service.CarichiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

  @GetMapping("/stato-mesi/verifica-stato")
  public boolean StatoMese(String statoMese, int anno, int mese, String codiceUtente) {
    return statoMese.equals("S");
  }
}
