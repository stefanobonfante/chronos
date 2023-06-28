package it.addvalue.chronos.repository;

import it.addvalue.chronos.model.entity.StimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface StimeRrepository extends JpaRepository<StimeEntity, String> {
  @Query(
      value = "SELECT * FROM TB_STIME WHERE COD_JOB = ?1 ORDER BY COD_JOB ASC, COD_TASK ASC",
      nativeQuery = true)
  List<StimeEntity> getTask(String cod_job);
  @Query(value = "select * from TB_STIME where COD_JOB=?1 and COD_TASK=?2 order by COD_JOB asc, COD_TASK asc, COD_SUBTASK asc",nativeQuery = true)
  List<StimeEntity> getSubTask (String cod_job,String cod_task);
}
