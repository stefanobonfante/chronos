package it.addvalue.chronos.repository;

import it.addvalue.chronos.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User, String> {


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
