package it.addvalue.chronos.model.mapper;

import it.addvalue.chronos.model.dto.JobDto;
import it.addvalue.chronos.model.entity.JobEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JobDtoJobEntityMapper
        implements IDtoEntityBidirectionalMapper<JobDto, JobEntity> {

    @Override
    public JobDto toDto(JobEntity jobEntity) {
        JobDto jobDto= new JobDto();
        jobDto.setCodStatoJob(jobEntity.getCodStatoJob());
        jobDto.setDesStatoJob(jobEntity.getDesStatoJob());
        return jobDto;
    }

    @Override
    public JobEntity toEntity(JobDto destinazioniDto) {
        JobEntity jobEntity = new JobEntity();
        jobEntity.setCodStatoJob(destinazioniDto.getCodStatoJob());
        jobEntity.setDesStatoJob(destinazioniDto.getDesStatoJob());
        return jobEntity;
    }

    @Override
    public List<JobDto> toDtos(List<JobEntity> entityList) {
        return IDtoEntityBidirectionalMapper.super.toDtos(entityList);
    }

    @Override
    public List<JobEntity> toEntities(List<JobDto> dtoList) {
        return IDtoEntityBidirectionalMapper.super.toEntities(dtoList);
    }
}
