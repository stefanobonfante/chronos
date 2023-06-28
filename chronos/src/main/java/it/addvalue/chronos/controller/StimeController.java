package it.addvalue.chronos.controller;

import it.addvalue.chronos.model.entity.StimeProjection;
import it.addvalue.chronos.service.StimeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/stime/")
public class StimeController {
  @Autowired public final StimeService stimeService;

  @GetMapping
  public ResponseEntity<List<StimeProjection>> getJob(@RequestParam String cod_job) {
    return ResponseEntity.ok(stimeService.recuperoTask(cod_job));
  }
}
