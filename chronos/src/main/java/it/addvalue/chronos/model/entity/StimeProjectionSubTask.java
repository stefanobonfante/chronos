package it.addvalue.chronos.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StimeProjectionSubTask {
  String codJob;
  String codTask;
  String codSubTask;
  String desSubTask;
}
