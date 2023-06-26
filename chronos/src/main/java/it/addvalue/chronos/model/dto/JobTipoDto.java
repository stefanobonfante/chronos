package it.addvalue.chronos.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobTipoDto {
    private String codTipoJob;
    private String desTipoJob;
    private String flgCharts;
    private String flgChartsBug;
    private String tipoControllo;
}