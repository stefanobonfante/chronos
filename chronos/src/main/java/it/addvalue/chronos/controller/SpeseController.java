package it.addvalue.chronos.controller;

import java.io.IOException;
import java.util.List;

import it.addvalue.chronos.core.exception.Custom;
import it.addvalue.chronos.model.dto.SpeseDto;
import it.addvalue.chronos.model.entity.SpeseEntity;
import it.addvalue.chronos.service.SpeseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/spese/")
public class SpeseController {

  private final SpeseService speservice;

  @Autowired
  public SpeseController(SpeseService speservice) {
    this.speservice = speservice;
  }

  @GetMapping(path = "{anno}/{mese}/{giorno}/{codUtente}")
  public ResponseEntity<List<SpeseEntity>> recuperoSpeseGiorno(
      @PathVariable int anno,
      @PathVariable int mese,
      @PathVariable int giorno,
      @PathVariable String codUtente)
      throws IOException {
    return ResponseEntity.ok(speservice.recuperoSpeseGiorno(anno, mese, giorno, codUtente));
  }

  @GetMapping(path = "{anno}/{mese}/{codUtente}")
  public ResponseEntity<List<SpeseEntity>> recuperoSpeseMese(
      @PathVariable int anno, @PathVariable int mese, @PathVariable String codUtente)
      throws IOException {
    return ResponseEntity.ok(speservice.recuperoSpeseMese(anno, mese, codUtente));
  }

  @PostMapping(path = "salvataggioSpese")
  public void salvataggioSpese(@PathVariable List<SpeseDto> spese) throws IOException, Custom {
    speservice.filtroSpese(spese);
  }

  @PutMapping(path = "{List<SpeseDto>}")
  public void modificaSpese(@PathVariable List<SpeseDto> spese) throws IOException, Custom {
    speservice.filtroSpese(spese);
  }
}
