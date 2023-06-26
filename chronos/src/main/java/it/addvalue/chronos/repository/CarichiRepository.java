package it.addvalue.chronos.repository;

import it.addvalue.chronos.model.entity.CarichiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarichiRepository extends JpaRepository<CarichiEntity, String> {
  @Query(
      value =
          "select * from TB_CARICHI\n"
              + "where ANNO=? and MESE=? and GIORNO=? and COD_UTENTE=?\n"
              + "order by ANNO asc, MESE asc, GIORNO asc, COD_JOB asc",
      nativeQuery = true)
  public List<CarichiEntity> queryCarichiGiorno(
      int anno, int mese, Integer giorno, String codiceUtente);

  @Query(
      value =
          "select * from TB_CARICHI\n"
              + "where ANNO=? and MESE=? and COD_UTENTE=?\n"
              + "order by ANNO asc, MESE asc, GIORNO asc, COD_JOB asc",
      nativeQuery = true)
  public List<CarichiEntity> queryCarichiMese(int anno, int mese, String codiceUtente);

  @Query(
      value =
          "SELECT * FROM TB_STATO_MESI\n "
              + "WHERE ANNO=? AND MESE=? AND COD_UTENTE=? AND CHIUSO=?",
      nativeQuery = true)
  List<CarichiEntity> queryStatoMese(int anno, int mese, String codiceUtente, String chiuso);

  @Query(
      value =
          "select * from TB_CARICHI where ANNO=?1 and MESE=?2 and GIORNO=?3 and COD_UTENTE=?4 and COD_JOB=?5",
      nativeQuery = true)
  List<CarichiEntity> queryPresenzaCarichi(
      int anno, int mese, int giorno, String codiceUtente, String codJob);
}
