package it.addvalue.chronos.controller;

import it.addvalue.chronos.model.entity.DestinazioniEntity;
import it.addvalue.chronos.service.DestinazioniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/destinations")
public class DestinazioniController {
    @Autowired
    DestinazioniService service;
    @GetMapping
    public ResponseEntity<ArrayList<DestinazioniEntity>> recuperoDestinazioni() throws IOException {
        return ResponseEntity.ok(service.recuperoDestinazioni());
    }
}
