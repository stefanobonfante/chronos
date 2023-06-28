package it.addvalue.chronos.repository;

import it.addvalue.chronos.model.entity.CarichiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CarichiRepository extends JpaRepository<CarichiEntity, String> {

  @Query(
      value =
          "select * from TB_CARICHI "
              + "where ANNO=?1 and MESE=?2 and GIORNO=?3 and COD_UTENTE=?4 "
              + "order by ANNO asc, MESE asc, GIORNO asc, COD_JOB asc",
      nativeQuery = true)
  List<CarichiEntity> queryCarichiGiorno(int anno, int mese, int giorno, String codiceUtente);
<<<<<<< HEAD

  @Query(value = "SELECT * FROM TB_UTENTI WHERE COD_UTENTE=?", nativeQuery = true)
  public Optional<ArrayList<User>> getUtente(String cod_utente);
=======
>>>>>>> dde552215286bd1fc37d7dded81f0ca24ef7e45a

  @Query(
      value =
          "select * from TB_CARICHI "
              + "where ANNO=?1 and MESE=?2 and COD_UTENTE=?3 "
              + "order by ANNO asc, MESE asc, GIORNO asc, COD_JOB asc",
      nativeQuery = true)
  List<CarichiEntity> queryCarichiMese(int anno, int mese, String codiceUtente);

<<<<<<< HEAD
  @Query(value = "SELECT * TB_CARICHI WHERE IdCarico=?", nativeQuery = true)
=======
  @Query(value = "SELECT * TB_CARICHI WHERE IdCarico=?1", nativeQuery = true)
>>>>>>> dde552215286bd1fc37d7dded81f0ca24ef7e45a
  public Optional<CarichiEntity> getFromTbcarichi(String id);

  @Query(
      value =
          "SELECT * FROM TB_STATO_MESI "
              + "WHERE ANNO=?1 AND MESE=?2 AND COD_UTENTE=?3 AND CHIUSO=?4",
      nativeQuery = true)
  List<CarichiEntity> queryStatoMese(int anno, int mese, String codiceUtente, String chiuso);
}
