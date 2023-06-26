package it.addvalue.chronos.service;

import it.addvalue.chronos.model.dto.JobDTO;
import it.addvalue.chronos.model.entity.JobEntity;
import it.addvalue.chronos.model.mapper.JobMapper;
import it.addvalue.chronos.repository.JobRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class JobService {
    @Autowired
    protected JobRepository repository;
    @Autowired
    protected JobMapper mapper;

    public List<JobDTO> checkCod(String filtroJob, String filtroCodCliente) {
            if (filtroJob == null && filtroCodCliente == null) {
                return mapper.toDtos(repository.findAll());
            } else if (filtroJob == null && filtroCodCliente != null) {
                return mapper.toDtos(repository.findByCodCliente(filtroCodCliente));
            } else if (filtroJob != null && filtroCodCliente == null) {
                return mapper.toDtos(repository.findAllByCodJob(filtroJob));
            } else {
                return mapper.toDtos(repository.cercaJob(filtroJob, filtroCodCliente));
            }
    }

    public List<JobDTO> getElencoAttivita(String codiceJob, String codiceTask, String codiceSubtask) {
        List<JobEntity> attivitaEntities = repository.queryElencoAttivita(codiceJob, codiceTask, codiceSubtask);
        return mapToJobDTO(attivitaEntities);
    }
    private List<JobDTO> mapToJobDTO(List<JobEntity> attivitaEntities) {
        List<JobDTO> jobDTOs = new ArrayList<>();
        for (JobEntity attivitaEntity : attivitaEntities) {
            JobDTO jobDTO = new JobDTO();
            jobDTO.setCodJob(attivitaEntity.getCodJob());
            jobDTO.setObbTask(attivitaEntity.getObbTask());
            jobDTO.setObbSubtask(attivitaEntity.getObbSubtask());
            jobDTO.setObbAttivita(attivitaEntity.getObbAttivita());
            jobDTOs.add(jobDTO);
        }
        return jobDTOs;
    }
}