package it.addvalue.chronos.repository;

import it.addvalue.chronos.model.entity.CarichiEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarichiRepository extends JpaRepository<CarichiEntity, String> {
  List<CarichiEntity> queryCarichiGiorno(int anno, int mese, Integer giorno, String codiceUtente);

  List<CarichiEntity> queryCarichiMese(int anno, int mese, String codiceUtente);
}
