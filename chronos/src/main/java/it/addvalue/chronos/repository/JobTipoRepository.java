package it.addvalue.chronos.repository;

import it.addvalue.chronos.model.entity.JobTipoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface JobTipoRepository extends JpaRepository<JobTipoEntity, String> {

    @Query(value = "select * from TB_TIPO_JOB where COD_TIPO_JOB <> '' order by COD_TIPO_JOB asc;", nativeQuery = true)
    ArrayList<JobTipoEntity> recuperoTipoJob();

}

