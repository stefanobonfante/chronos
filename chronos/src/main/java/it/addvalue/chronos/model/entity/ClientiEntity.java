package it.addvalue.chronos.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_CLIENTI")
public class ClientiEntity {
    @Column(name = "COD_CLIENTE")
    private String codCliente;
    @Column(name = "RAG_SOCIALE")
    private String ragSociale;
    @Column(name = "COD_CIMAV")
    private int codCimav;
    @Column(name = "COD_CLIENTE_PANT")
    private String codClientePant;
}
