package it.addvalue.chronos.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DestinazioniDto {
    private String codDestinazione;
    private String desDestinazione;
    private String oreViaggio;
    private String kmViaggio;
}