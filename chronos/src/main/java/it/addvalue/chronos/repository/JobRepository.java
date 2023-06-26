package it.addvalue.chronos.repository;

import it.addvalue.chronos.model.entity.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<JobEntity, String> {

  @Query(
      value = "select * from TB_JOBS where COD_JOB = ?1 AND COD_CLIENTE = ?2 ;",
      nativeQuery = true)
  JobEntity recuperoDettagliJob(String codJob, String codCliente);

  @Query(value = "select * from TB_JOBS where COD_JOB = ?1 ;", nativeQuery = true)
  JobEntity recuperoJob(String codJob);
}
