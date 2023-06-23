package it.addvalue.chronos.service;

import it.addvalue.chronos.model.entity.JobEntity;
import it.addvalue.chronos.model.mapper.JobDtoJobEntityMapper;
import it.addvalue.chronos.repository.JobRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    private static final String TABLE_NAME = "TB_STATO_JOB";
    protected static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    protected JobRepository repository;
    @Autowired
    protected JobDtoJobEntityMapper mapper;

    public List<JobEntity> recuperoStatiJob() {
        return repository.recuperoStatiJob();
    }
}