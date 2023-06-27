package it.addvalue.chronos.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class clientiDTO {
  private String codCliente;
  private String ragSociale;
  private Integer codCimav;
  private String codClientePant;
}
