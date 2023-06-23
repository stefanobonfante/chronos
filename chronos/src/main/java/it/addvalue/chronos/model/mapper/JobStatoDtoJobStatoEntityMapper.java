package it.addvalue.chronos.model.mapper;

import it.addvalue.chronos.model.dto.JobStatoDto;
import it.addvalue.chronos.model.entity.JobStatoEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JobStatoDtoJobStatoEntityMapper
        implements IDtoEntityBidirectionalMapper<JobStatoDto, JobStatoEntity> {

    @Override
    public JobStatoDto toDto(JobStatoEntity jobEntity) {
        JobStatoDto jobDto= new JobStatoDto();
        jobDto.setCodStatoJob(jobEntity.getCodStatoJob());
        jobDto.setDesStatoJob(jobEntity.getDesStatoJob());
        return jobDto;
    }
    @Override
    public JobStatoEntity toEntity(JobStatoDto jobDto) {
        JobStatoEntity jobEntity = new JobStatoEntity();
        jobEntity.setCodStatoJob(jobDto.getCodStatoJob());
        jobEntity.setDesStatoJob(jobDto.getDesStatoJob());
        return jobEntity;
    }

    @Override
    public List<JobStatoDto> toDtos(List<JobStatoEntity> entityList) {
        return IDtoEntityBidirectionalMapper.super.toDtos(entityList);
    }

    @Override
    public List<JobStatoEntity> toEntities(List<JobStatoDto> dtoList) {
        return IDtoEntityBidirectionalMapper.super.toEntities(dtoList);
    }
}
