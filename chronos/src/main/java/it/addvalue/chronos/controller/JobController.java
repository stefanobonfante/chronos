package it.addvalue.chronos.controller;

import it.addvalue.chronos.model.dto.JobDTO;
import it.addvalue.chronos.service.JobService;
import lombok.AllArgsConstructor;
<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
=======
>>>>>>> dde552215286bd1fc37d7dded81f0ca24ef7e45a
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/job")
public class JobController {

  @Autowired protected final JobService service;

  @GetMapping
  public ResponseEntity<List<JobDTO>> getJob(String filtroJob, String filtroCodCliente) {
    return ResponseEntity.ok(service.checkCod(filtroJob, filtroCodCliente));
  }

  @GetMapping("/api/jobs/attivita")
  public List<JobDTO> getElencoAttivita(
      @RequestParam("job") String codiceJob,
      @RequestParam("task") String codiceTask,
      @RequestParam("subtask") String codiceSubtask) {
    return service.getElencoAttivita(codiceJob, codiceTask, codiceSubtask);
  }
}
