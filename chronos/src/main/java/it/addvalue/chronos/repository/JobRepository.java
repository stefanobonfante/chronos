package it.addvalue.chronos.repository;

import it.addvalue.chronos.model.entity.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<JobEntity,String> {

    @Query(value = "SELECT * FROM TB_JOBS WHERE COD_JOB=?1 AND COD_CLIENTE=?2",nativeQuery = true)
    List<JobEntity> cercaJob(String codJob,String cod_cliente);


    @Query(value = "SELECT * FROM TB_JOBS WHERE COD_CLIENTE=?1",nativeQuery = true)
    List<JobEntity> findByCodCliente(String cod);


    List<JobEntity> findAllByCodJob(String cod);
}


