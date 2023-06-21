package it.addvalue.chronos.repository;

import it.addvalue.chronos.model.entity.SpeseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface SpeseRepository extends JpaRepository <SpeseEntity,String>{

    @Query(value = "select * " +
            "from TB_SPESE " +
            "inner join TB_JOBS on TB_JOBS.COD_JOB=TB_SPESE.COD_JOB " +
            "where ANNO=?1 and MESE=?2 and GIORNO=?3 and COD_UTENTE=?4 " +
            "order by ANNO asc, MESE asc, GIORNO asc, TB_SPESE.COD_JOB asc", nativeQuery = true)
    ArrayList<SpeseEntity> recuperoSpeseGiorno(int anno, int mese, int giorno, String codUtente);

    @Query(value = "select * "+
            "from TB_SPESE "+
            "inner join TB_JOBS on TB_JOBS.COD_JOB=TB_SPESE.COD_JOB "+
            "where ANNO=?1 and MESE=?2 and COD_UTENTE=?3 "+
            "order by ANNO asc, MESE asc, GIORNO asc, COD_JOB asc", nativeQuery = true)
    ArrayList<SpeseEntity> recuperoSpeseMese(int anno, int mese, String codUtente);


    @Query(value = "DELETE FROM TB_SPESE"+
                    " where ID_SPESE=?1", nativeQuery = true)
    int RecuperoSpesaDaEliminare(String speseId);

}
