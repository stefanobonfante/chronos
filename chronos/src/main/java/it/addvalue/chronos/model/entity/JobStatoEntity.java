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
@Table(name = "TB_STATO_JOB")
public class JobStatoEntity {
    @Id
    @Column(name = "COD_STATO_JOB")
    private String codStatoJob;
    @Column(name = "DES_STATO_JOB")
    private String desStatoJob;
}
