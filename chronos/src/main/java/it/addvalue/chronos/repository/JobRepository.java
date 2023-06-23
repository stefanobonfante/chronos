package it.addvalue.chronos.repository;

import it.addvalue.chronos.model.entity.JobEntity;
import it.addvalue.chronos.model.entity.SpeseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Repository
public interface JobRepository extends JpaRepository<JobEntity, String> {

    @Query(value = "select * from TB_STATO_JOB order by COD_STATO_JOB asc, DES_STATO_JOB asc;", nativeQuery = true)
    ArrayList<JobEntity> recuperoStatiJob();

}

