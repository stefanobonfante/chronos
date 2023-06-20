package it.addvalue.chronos.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.addvalue.chronos.model.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, String> {
    @Query(value = "SELECT * FROM TB_UTENTI WHERE COD_UTENTE=?")
    public Optional<List<User>> getLivelloUtente (String cod_utente);
}
