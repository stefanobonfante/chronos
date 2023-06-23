package it.addvalue.chronos.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface IUserRepository extends JpaRepository<User, String> {

  Optional<List<User>> findByCodUtente(String cod_utente);

  @Query(
      name =
          "select * "
              + "from TB_UTENTI "
              +
              /*" CANCELLATO='N'*/ "where COD_UTENTE=? "
              + "order by COD_UTENTE asc, DES_UTENTE asc",
      nativeQuery = true)
  ArrayList<User> ordinaUsersConAuth(String auth);

  @Query(
      name =
          "select * "
              + "from TB_UTENTI "
              +
              // "where CANCELLATO='N' " +
              "order by COD_UTENTE asc, DES_UTENTE asc",
      nativeQuery = true)
  ArrayList<User> ordinaUsers();
}
