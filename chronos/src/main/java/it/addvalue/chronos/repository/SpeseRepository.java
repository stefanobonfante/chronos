package it.addvalue.chronos.repository;

import it.addvalue.chronos.model.entity.SpeseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpeseRepository extends JpaRepository <SpeseEntity,String>{

    @Query("select * " +
            "from TB_SPESE " +
            "inner join TB_JOBS on TB_JOBS.COD_JOB=TB_SPESE.COD_JOB " +
            "where ANNO=? and MESE=? and GIORNO=? and COD_UTENTE=? " +
            "order by ANNO asc, MESE asc, GIORNO asc, COD_JOB asc")
    List<SpeseEntity> recuperoSpeseGiorno(int anno, int mese, int giorno, String codUtente);

    @Query("select * "+
            "from TB_SPESE "+
            "inner join TB_JOBS on TB_JOBS.COD_JOB=TB_SPESE.COD_JOB "+
            "where ANNO=? and MESE=? and COD_UTENTE=? "+
            "order by ANNO asc, MESE asc, GIORNO asc, COD_JOB asc")
    List<SpeseEntity> recuperoSpeseMese(int anno, int mese, String codUtente);
}
