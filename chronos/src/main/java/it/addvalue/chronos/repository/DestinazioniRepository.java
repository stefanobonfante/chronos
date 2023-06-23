package it.addvalue.chronos.repository;

import it.addvalue.chronos.model.entity.DestinazioniEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface DestinazioniRepository extends JpaRepository<DestinazioniEntity, String> {

    @Query(value = "select * from TB_DEST_VIAGGIO", nativeQuery = true)
    ArrayList<DestinazioniEntity> recuperoDestinazioni();

}

