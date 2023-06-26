package it.addvalue.chronos.controller;

import it.addvalue.chronos.model.dto.clientiDTO;
import it.addvalue.chronos.service.ClientiService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/clienti")
public class ClientiController {

  @Autowired ClientiService clientiservice;

  @GetMapping
  public ResponseEntity<List<clientiDTO>> recuperaClienti() throws IOException {
    return ResponseEntity.ok(clientiservice.recuperaClienti());
  }
}
