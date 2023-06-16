package it.addvalue.chronos.model.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {
  private static final long serialVersionUID = -6432815031405125427L;

  private String userCode;
  private int level;
}
