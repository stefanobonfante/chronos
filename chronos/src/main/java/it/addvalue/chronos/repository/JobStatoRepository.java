package it.addvalue.chronos.repository;

import it.addvalue.chronos.model.entity.JobStatoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface JobStatoRepository extends JpaRepository<JobStatoEntity, String> {

    @Query(value = "select * from TB_STATO_JOB order by COD_STATO_JOB asc, DES_STATO_JOB asc;", nativeQuery = true)
    ArrayList<JobStatoEntity> recuperoStatiJob();

    @Query(value = "select * from TB_TIPO_JOB where COD_TIPO_JOB <> '' order by COD_TIPO_JOB asc;", nativeQuery = true)
    ArrayList<JobStatoEntity> recuperoTipiJob();

}

