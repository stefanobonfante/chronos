package it.addvalue.chronos.repository;

import it.addvalue.chronos.model.entity.CarichiEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.addvalue.chronos.model.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, String> {
  @Query(value = "SELECT * FROM TB_UTENTI WHERE COD_UTENTE=?")
  public Optional<List<User>> getLivelloUtente(String cod_utente);

  @Query(value = "select * from TB_CARICHI\n" +
          "where ANNO=? and MESE=? and GIORNO=? and COD_UTENTE=?\n" +
          "order by ANNO asc, MESE asc, GIORNO asc, COD_JOB asc")
  public   List<CarichiEntity> queryCarichiGiorno(int anno, int mese, Integer giorno, String codiceUtente);

  @Query(value = "select * from TB_CARICHI\n" +
          "where ANNO=? and MESE=? and COD_UTENTE=?\n" +
          "order by ANNO asc, MESE asc, GIORNO asc, COD_JOB asc")
  public   List<CarichiEntity> queryCarichiMese(int anno, int mese, String codiceUtente);
}
