package it.addvalue.chronos.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_DEST_VIAGGIO")
public class DestinazioniEntity {
    @Id
    @Column(name = "COD_DESTINAZIONE")
    private String codDestinazione;
    @Column(name = "DES_DESTINAZIONE")
    private String desDestinazione;
    @Column(name = "ORE_VIAGGIO")
    private String oreViaggio;
    @Column(name = "KM_VIAGGIO")
    private String kmViaggio;

}
