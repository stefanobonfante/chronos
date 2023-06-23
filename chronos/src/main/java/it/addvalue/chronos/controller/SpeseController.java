package it.addvalue.chronos.controller;

import it.addvalue.chronos.core.exception.Custom;
import it.addvalue.chronos.model.dto.SpeseDto;
import it.addvalue.chronos.model.entity.SpeseEntity;
import it.addvalue.chronos.service.SpeseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/spese/")
public class SpeseController {


    @Autowired
    SpeseService service;

    @GetMapping(path = "{anno}/{mese}/{giorno}/{codUtente}")
    public ResponseEntity<ArrayList<SpeseEntity>> recuperoSpeseGiorno(
            @PathVariable int anno,
            @PathVariable int mese,
            @PathVariable int giorno,
            @PathVariable String codUtente)
            throws IOException {
        return ResponseEntity.ok(service.recuperoSpeseGiorno(anno, mese, giorno, codUtente));
    }

    @GetMapping(path = "{anno}/{mese}/{codUtente}")
    public ResponseEntity<ArrayList<SpeseEntity>> recuperoSpeseMese(
            @PathVariable int anno,
            @PathVariable int mese,
            @PathVariable String codUtente)
            throws IOException {
        return ResponseEntity.ok(service.recuperoSpeseMese(anno, mese, codUtente));
    }

    @PostMapping
    public void salvataggioSpese(@RequestBody ArrayList<SpeseDto> spese) throws IOException, Custom {
        service.filtroSpese(spese);
    }

    @PutMapping
    public void modificaSpese(@RequestBody ArrayList<SpeseDto> spese) throws IOException, Custom {
        service.filtroSpese(spese);
    }

    @DeleteMapping(path = "/cancellaSpese")
    public void cancellaSpese(@RequestBody  ArrayList<SpeseDto> spese) throws Custom {
        service.deleatElementi(spese);
    }

}
