package it.addvalue.chronos.service;

import it.addvalue.chronos.model.entity.JobStatoEntity;
import it.addvalue.chronos.model.entity.JobTipoEntity;
import it.addvalue.chronos.model.entity.JobEntity;
import it.addvalue.chronos.model.mapper.JobStatoDtoJobStatoEntityMapper;
import it.addvalue.chronos.repository.JobStatoRepository;
import it.addvalue.chronos.repository.JobTipoRepository;
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
    protected JobStatoRepository statoRepository;
    @Autowired
    protected JobTipoRepository tipoRepository;
    @Autowired
    protected JobRepository repository;
    @Autowired
    protected JobStatoDtoJobStatoEntityMapper mapper;

    public List<JobStatoEntity> recuperoStatiJob() {
        return statoRepository.recuperoStatiJob();
    }

    public List<JobTipoEntity> recuperoTipoJob() {
        return tipoRepository.recuperoTipoJob();
    }
}