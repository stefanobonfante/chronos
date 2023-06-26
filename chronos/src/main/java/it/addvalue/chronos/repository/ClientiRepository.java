package it.addvalue.chronos.repository;

import it.addvalue.chronos.model.entity.ClientiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientiRepository extends JpaRepository<ClientiEntity, String> {
    @Query(
            value =
                    "select COD_CLIENTE, RAG_SOCIALE from TB_CLIENTI \n" +
                            "where COD_CLIENTE <> 'ADV' order by RAG_SOCIALE asc;", nativeQuery = true)
    List<ClientiEntity> queryRecuperoClienti();



}