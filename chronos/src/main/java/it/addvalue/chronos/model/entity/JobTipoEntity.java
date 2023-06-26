package it.addvalue.chronos.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_TIPO_JOB")
public class JobTipoEntity {
  @Id
  @Column(name = "COD_TIPO_JOB")
  private String codTipoJob;

  @Column(name = "DES_TIPO_JOB")
  private String desTipoJob;

  @Column(name = "FLG_CHARTS")
  private String flgCharts;

  @Column(name = "FLG_CHARTS_BUG")
  private String flgChartsBug;

  @Column(name = "TIPO_CONTROLLO")
  private String tipoControllo;
}
