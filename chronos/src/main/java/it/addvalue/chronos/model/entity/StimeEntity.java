package it.addvalue.chronos.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_STIME")
public class StimeEntity {

  @Id
  @Column(name="CODSTIMA")
  private String idStima;

  @Column(name = "COD_JOB")
  private String codJob;

  @Column(name = "DES_JOB")
  private String desJob;

  @Column(name = "COD_TASK")
  private String codTask;

  @Column(name = "DES_TASK")
  private String desTask;

  @Column(name = "COD_SUBTASK")
  private String codSubtask;

  @Column(name = "DES_SUBTASK")
  private String desSubtask;

  @Column(name = "COD_SUBSUBTASK")
  private String codSubsubtask;

  @Column(name = "DES_SUBSUBTASK")
  private String desSubsubtask;

  @Column(name = "COD_ATTIVITA")
  private String codAttivita;

  @Column(name = "ORE")
  private int ore;

  @Column(name = "NOTE")
  private String note;

  @Column(name = "TMS_ULTIMAMOD")
  private String tmsUltimamod;

  @Column(name = "COLONNA_FITTIZIA")
  private String colonnaFittizzia;
}
