package it.addvalue.chronos.controller;

import it.addvalue.chronos.core.exception.CustomException;
import it.addvalue.chronos.model.dto.JobDto;
import it.addvalue.chronos.model.entity.JobStatoEntity;
import it.addvalue.chronos.model.entity.JobTipoEntity;
import it.addvalue.chronos.model.entity.SpeseEntity;
import it.addvalue.chronos.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/jobs/")
public class JobController {
    @Autowired
    JobService service;
    @GetMapping("stati")
    public ResponseEntity<List<JobStatoEntity>> recuperoStatiJob() throws IOException {
        return ResponseEntity.ok(service.recuperoStatiJob());
    }

    @GetMapping("tipi")
    public ResponseEntity<List<JobTipoEntity>> recuperoTipiJob() throws IOException {
        return ResponseEntity.ok(service.recuperoTipoJob());
    }

    @PostMapping
    public void salvataggioJob(@RequestBody List<JobDto> jobs) throws IOException, CustomException {
        service.salvataggioJob(jobs);
    }

    @PutMapping
    public boolean modificaJobs(@RequestBody List<JobDto> jobs) throws IOException, CustomException {
        return(service.modificaJob(jobs));
    }

    //@GetMapping
    //public boolean chiusuraJob(@RequestBody List<JobDto> jobs) throws IOException, CustomException {
    //    service.chiusuraJob(jobs);

    //}
    @GetMapping(path = "dettaglio/{codJob}/{codCliente}")
    public ResponseEntity<JobDto> recuperoDettaglioJob (
            @PathVariable String codJob,
            @PathVariable String codCliente)
            throws IOException, CustomException {
        return ResponseEntity.ok(service.recuperoDettaglioJob(codJob,codCliente));
    }

    @GetMapping(path = "dettaglio/{codJob}")
    public void controlloChiusuraJob (
            @PathVariable String codJob)
            throws IOException, CustomException {
        service.controlloChiusuraJob(codJob);
    }



}
