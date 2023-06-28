package it.addvalue.chronos.repository;

import org.springframework.data.jpa.repository.Query;
import it.addvalue.chronos.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, String> {
  @Query(value = "SELECT LIVELLO FROM TB_UTENTI ", nativeQuery = true)
  public Optional<ArrayList<String>> getLivelloUtente();

  @Query(value = "SELECT * FROM TB_UTENTI WHERE COD_UTENTE=?1", nativeQuery = true)
  public Optional<List<User>> getLivelloUtente1(String cod_utente);

  @Query(
      value =
          "select * "
              + "from TB_UTENTI "
              + "where CANCELLATO=”N” and COD_UTENTE=? "
              + "order by COD_UTENTE asc, DES_UTENTE asc",
      nativeQuery = true)
  public List<User> QuerylistaUtentiAuth(String auth);

  @Query(
      value =
          "select * "
              + "from TB_UTENTI "
              + "where CANCELLATO=”N” "
              + "order by COD_UTENTE asc, DES_UTENTE asc",
      nativeQuery = true)
  public List<User> QuerylistaUtentiNoAuth();
  
  User findByUserCode(String userCode);

  @Query(
      value =
          "select * "
              + "from TB_UTENTI "
              + " where CANCELLATO='N' and COD_UTENTE= ?1 "
              + "order by COD_UTENTE asc, DES_UTENTE asc",
      nativeQuery = true)
  List<User> ordinaUsersConAuth(String auth);

  @Query(
      value =
          "select * "
              + "from TB_UTENTI where CANCELLATO='N' "
              + "order by COD_UTENTE asc, DES_UTENTE asc",
      nativeQuery = true)
  List<User> ordinaUsers();
}
