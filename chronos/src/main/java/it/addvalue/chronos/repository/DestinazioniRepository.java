package it.addvalue.chronos.repository;

import it.addvalue.chronos.model.entity.DestinazioniEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinazioniRepository extends JpaRepository<DestinazioniEntity, String> {}
