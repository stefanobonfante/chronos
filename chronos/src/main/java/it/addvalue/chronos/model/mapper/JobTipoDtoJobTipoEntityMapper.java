package it.addvalue.chronos.model.mapper;

import it.addvalue.chronos.model.dto.JobTipoDto;
import it.addvalue.chronos.model.entity.JobTipoEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JobTipoDtoJobTipoEntityMapper implements IDtoEntityBidirectionalMapper<JobTipoDto, JobTipoEntity> {
    @Override
    public JobTipoDto toDto(JobTipoEntity jobEntity) {
        JobTipoDto jobDto = new JobTipoDto();
        jobDto.setDesTipoJob(jobEntity.getDesTipoJob());
        jobDto.setCodTipoJob(jobEntity.getCodTipoJob());
        jobDto.setTipoControllo(jobEntity.getTipoControllo());
        jobDto.setFlgCharts(jobEntity.getFlgCharts());
        jobDto.setFlgChartsBug(jobEntity.getFlgChartsBug());
        return jobDto;
    }

    @Override
    public JobTipoEntity toEntity(JobTipoDto jobDto) {
        JobTipoEntity jobEntity = new JobTipoEntity();
        jobDto.setDesTipoJob(jobEntity.getDesTipoJob());
        jobDto.setCodTipoJob(jobEntity.getCodTipoJob());
        jobDto.setTipoControllo(jobEntity.getTipoControllo());
        jobDto.setFlgCharts(jobEntity.getFlgCharts());
        jobDto.setFlgChartsBug(jobEntity.getFlgChartsBug());
        return jobEntity;
    }

    @Override
    public List<JobTipoDto> toDtos(List<JobTipoEntity> entityList) {
        return IDtoEntityBidirectionalMapper.super.toDtos(entityList);
    }

    @Override
    public List<JobTipoEntity> toEntities(List<JobTipoDto> dtoList) {
        return IDtoEntityBidirectionalMapper.super.toEntities(dtoList);
    }
}