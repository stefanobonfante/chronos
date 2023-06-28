package it.addvalue.chronos.controller;

import it.addvalue.chronos.service.CarichiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mesi")
public class GestioneMesiController {
  private CarichiService carichiService; // Riferimento al service per il recupero dei carichi

  @GetMapping("/stato-mesi/verifica-stato")
  public boolean StatoMese(String statoMese, int anno, int mese, String codiceUtente) {
    return statoMese.equals("S");
  }
}
