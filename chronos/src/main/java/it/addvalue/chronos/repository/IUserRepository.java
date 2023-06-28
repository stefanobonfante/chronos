package it.addvalue.chronos.repository;

import it.addvalue.chronos.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
<<<<<<< HEAD
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
=======
>>>>>>> dde552215286bd1fc37d7dded81f0ca24ef7e45a

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
