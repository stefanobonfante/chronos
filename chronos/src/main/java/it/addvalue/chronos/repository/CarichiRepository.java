package it.addvalue.chronos.repository;

import it.addvalue.chronos.model.entity.CarichiEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarichiRepository extends JpaRepository<CarichiEntity,String> {


    List<CarichiEntity> query1(int anno, int mese, String codiceUtente);

    List<CarichiEntity> query2(int anno, int mese, Integer giorno, String codiceUtente);
}
