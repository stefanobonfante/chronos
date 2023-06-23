package it.addvalue.chronos.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import it.addvalue.chronos.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, String> {
    @Query(value = "SELECT COD_UTENTE FROM TB_UTENTI ")
    public Optional<ArrayList<User>> getLivelloUtente();
}