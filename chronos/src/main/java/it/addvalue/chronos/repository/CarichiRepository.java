package it.addvalue.chronos.repository;

import it.addvalue.chronos.model.entity.CarichiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarichiRepository extends JpaRepository<CarichiEntity, String> {

  @Query(
      value =
          "select * from TB_CARICHI"
              + "where ANNO=?1 and MESE=?2 and GIORNO=?3 and COD_UTENTE=?4 "
              + "order by ANNO asc, MESE asc, GIORNO asc, COD_JOB asc",
      nativeQuery = true)
  List<CarichiEntity> queryCarichiGiorno(int anno, int mese, int giorno, String codiceUtente);

  @Query(
      value =
          "select * from TB_CARICHI "
              + "where ANNO=?1 and MESE=?2 and COD_UTENTE=?3 "
              + "order by ANNO asc, MESE asc, GIORNO asc, COD_JOB asc",
      nativeQuery = true)
  List<CarichiEntity> queryCarichiMese(int anno, int mese, String codiceUtente);
}
