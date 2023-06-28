package it.addvalue.chronos.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StimeDTO {
  private String codJob;
  private String desJob;
  private String codTask;
  private String desTask;
  private String codSubtask;
  private String desSubtask;
  private String codSubsubtask;
  private String desSubsubtask;
  private String codAttivita;
  private int ore;
  private String note;
  private String tmsUltimamod;
  private String colonnaFittizzia;
  private String idStima;
}
