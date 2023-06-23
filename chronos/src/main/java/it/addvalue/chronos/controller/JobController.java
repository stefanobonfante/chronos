package it.addvalue.chronos.controller;

import it.addvalue.chronos.model.entity.JobEntity;
import it.addvalue.chronos.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/jobs/")
public class JobController {
    @Autowired
    JobService service;
    @GetMapping("stati")
    public ResponseEntity<List<JobEntity>> recuperoStatiJob() throws IOException {
        return ResponseEntity.ok(service.recuperoStatiJob());
    }
}
