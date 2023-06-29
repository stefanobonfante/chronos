package it.addvalue.chronos.controller;

import it.addvalue.chronos.core.exception.EsecuzioneErrataException;
import it.addvalue.chronos.model.entity.StimeProjection;
import it.addvalue.chronos.model.entity.StimeProjectionSubTask;
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

  @GetMapping(path = "getTask")
  public ResponseEntity<List<StimeProjection>> getTask(@RequestParam String cod_job)
      throws EsecuzioneErrataException {
    return ResponseEntity.ok(stimeService.recuperoTask(cod_job));
  }

  @GetMapping(path = "getSubTask")
  public ResponseEntity<List<StimeProjectionSubTask>> getSubTask(
      @RequestParam String cod_job, @RequestParam String cod_task)
      throws EsecuzioneErrataException {
    return ResponseEntity.ok(stimeService.recuperoSubTask(cod_job, cod_task));
  }
}
