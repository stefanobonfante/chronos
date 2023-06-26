package it.addvalue.chronos.repository;

import it.addvalue.chronos.model.entity.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<JobEntity, String> {

  @Query(value = "SELECT * FROM TB_JOBS WHERE COD_JOB=?1 AND COD_CLIENTE=?2", nativeQuery = true)
  List<JobEntity> cercaJob(String codJob, String cod_cliente);

  @Query(value = "SELECT * FROM TB_JOBS WHERE COD_CLIENTE=?1", nativeQuery = true)
  List<JobEntity> findByCodCliente(String cod);

  List<JobEntity> findAllByCodJob(String cod);

  @Query(
      value =
          "SELECT COD_JOB, COD_TASK, COD_SUBTASK, COD_ATTIVITA "
              + "FROM TB_STIME "
              + "WHERE COD_JOB = ?1 AND COD_TASK = ?2 AND COD_SUBTASK = ?3 "
              + "GROUP BY COD_JOB, COD_TASK, COD_SUBTASK, COD_ATTIVITA "
              + "ORDER BY COD_JOB ASC, COD_TASK ASC, COD_SUBTASK ASC, COD_ATTIVITA ASC",
      nativeQuery = true)
  List<JobEntity> queryElencoAttivita(String codiceJob, String codiceTask, String codiceSubtask);
}
