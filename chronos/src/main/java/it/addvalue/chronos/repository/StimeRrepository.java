package it.addvalue.chronos.repository;

import it.addvalue.chronos.model.entity.StimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface StimeRrepository extends JpaRepository<StimeEntity, String> {
  @Query(
      value = "SELECT * FROM TB_STIME WHERE COD_JOB = ?1 ORDER BY COD_JOB ASC, COD_TASK ASC",
      nativeQuery = true)
  List<StimeEntity> getStime(String cod_job);
}
