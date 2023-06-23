package it.addvalue.chronos.repository;

import it.addvalue.chronos.model.entity.CarichiEntity;
import it.addvalue.chronos.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface CarichiRepository extends JpaRepository<CarichiEntity, Integer> {

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
  
  @Query(value = "SELECT * TB_CARICHI WHERE IdCarico=?",nativeQuery = true)
  public Optional<CarichiEntity> getFromTbcarichi(String id);

  @Query(
      value =
          "SELECT * FROM TB_STATO_MESI "
              + "WHERE ANNO=?1 AND MESE=?2 AND COD_UTENTE=?3 AND CHIUSO=?4", nativeQuery = true)
  List<CarichiEntity> queryStatoMese(int anno, int mese, String codiceUtente, String chiuso);

}
