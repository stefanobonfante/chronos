package it.addvalue.chronos.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Access;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StimeProjectionSubTask {
    String codJob;
    String CodTask;
    String codSubTask;
    String desSubTask;

}
