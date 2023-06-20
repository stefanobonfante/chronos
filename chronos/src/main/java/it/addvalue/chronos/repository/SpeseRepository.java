package it.addvalue.chronos.repository;

import it.addvalue.chronos.model.entity.SpeseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface SpeseRepository extends JpaRepository<SpeseEntity, String> {

  @Query(
      value =
          "select * "
              + "from TB_SPESE "
              + "inner join TB_JOBS on TB_JOBS.COD_JOB=TB_SPESE.COD_JOB "
              + "where ANNO=?1 and MESE=?2 and GIORNO=?3 and COD_UTENTE=?4 "
              + "order by ANNO asc, MESE asc, GIORNO asc, TB_SPESE.COD_JOB asc",
      nativeQuery = true)
  List<SpeseEntity> recuperoSpeseGiorno(int anno, int mese, int giorno, String codUtente);

  @Query(
      value =
          "select * "
              + "from TB_SPESE "
              + "inner join TB_JOBS on TB_JOBS.COD_JOB=TB_SPESE.COD_JOB "
              + "where ANNO=?1 and MESE=?2 and COD_UTENTE=?3 "
              + "order by ANNO asc, MESE asc, GIORNO asc, COD_JOB asc",
      nativeQuery = true)
  List<SpeseEntity> recuperoSpeseMese(int anno, int mese, String codUtente);

  @Query(
      value =
          "INSERT INTO TB_SPESE (idSpese, codUtente, codJob, anno, mese, giorno, percorso, kmPercorsi, rimborsoKm, Carburante, pedaggi, altro, anticipi, parcheggi, trasporti, totSpese, trasferta, flgAndata, flgRitorno, totOreViaggio, reperibilita, flgAutoPf, flgAutoAr)\n"
              + "VALUES ('valore_idSpese', 'valore_codUtente', 'valore_codJob', valore_anno, valore_mese, valore_giorno, 'valore_percorso', valore_kmPercorsi, valore_rimborsoKm, valore_Carburante, valore_pedaggi, valore_altro, valore_anticipi, valore_parcheggi, valore_trasporti, valore_totSpese, valore_trasferta, 'valore_flgAndata', 'valore_flgRitorno', valore_totOreViaggio, valore_reperibilita, 'valore_flgAutoPf', 'valore_flgAutoAr');",
      nativeQuery = true)
  int modificaDB(
      String idSpese,
      String codUtente,
      String codJob,
      int anno,
      int mese,
      int giorno,
      String percorso,
      int kmPercorsi,
      int rimborsoKm,
      int Carburante,
      int pedaggi,
      int altro,
      int anticipi,
      int parcheggi,
      int trasporti,
      int totSpese,
      int trasferta,
      String flgAndata,
      String flgRitorno,
      BigDecimal totOreViaggio,
      int reperibilita,
      String flgAutoPf,
      String flgAutoAr);
}
