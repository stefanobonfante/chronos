package it.addvalue.chronos.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import it.addvalue.chronos.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, String> {
    @Query(value = "SELECT LIVELLO FROM TB_UTENTI ",nativeQuery = true)
    public Optional<ArrayList<String>> getLivelloUtente();

    @Query(value = "SELECT * FROM TB_UTENTI WHERE COD_UTENTE=?1")
    public Optional<List<User>> getLivelloUtente1(String cod_utente);

    @Query(
            name =
                    "select * "
                            + "from TB_UTENTI "
                            + "where CANCELLATO=”N” and COD_UTENTE=? "
                            + "order by COD_UTENTE asc, DES_UTENTE asc")
    public List<User> QuerylistaUtentiAuth(String auth);

    @Query(
            name =
                    "select * "
                            + "from TB_UTENTI "
                            + "where CANCELLATO=”N” "
                            + "order by COD_UTENTE asc, DES_UTENTE asc")
    public List<User> QuerylistaUtentiNoAuth();


}