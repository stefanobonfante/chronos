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
@Table(name = "TB_SPESE")
public class SpeseEntity {
    @Id
    private String idSpese;

    @Column(name="COD_UTENTE")
    private String codUtente;

    @Column(name="COD_JOB")
    private String codJob;

    @Column(name="ANNO")
    private int anno;

    @Column(name="MESE")
    private int mese;

    @Column(name="GIORNO")
    private int giorno;

    @Column(name="PERCORSO")
    private String percorso;

    @Column(name="KM_PERCORSI")
    private int kmPercorsi;

    @Column(name="RIMBORSO_KM")
    private int rimborsoKm;

    @Column(name="CARBURANTE")
    private int carburante;

    @Column(name="PEDAGGI")
    private int pedaggi;

    @Column(name="ALTRO")
    private int altro;

    @Column(name="ANTICIPI")
    private int anticipi;

    @Column(name="PARCHEGGI")
    private int parcheggi;

    @Column(name="TRASPORTI")
    private int trasporti;

    @Column(name="TOT_SPESE")
    private int totSpese;

    @Column(name="TRASFERTA")
    private int trasferta;

}
