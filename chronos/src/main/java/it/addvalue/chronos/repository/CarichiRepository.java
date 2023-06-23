package it.addvalue.chronos.repository;

import it.addvalue.chronos.model.entity.CarichiEntity;
import it.addvalue.chronos.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface CarichiRepository extends JpaRepository<CarichiEntity, String> {

  @Query(value = "SELECT * FROM TB_UTENTI WHERE COD_UTENTE=?",nativeQuery = true)
  public Optional<ArrayList<User>> getUtente(String cod_utente);

  @Query(value = "SELECT * TB_CARICHI WHERE IdCarico=?",nativeQuery = true)
  public Optional<CarichiEntity> getFromTbcarichi(String id);
}
