package it.addvalue.chronos.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_SPESE")
public class SpeseEntity {
    @Id
    @Column(name="ID_SPESE")
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

    @Column(name="FLG_ANDATA")
    private String flgAndata;

    @Column(name="FLG_RITORNO")
    private String flgRitorno;

    @Column(name="TOT_ORE_VIAGGIO")
    private BigDecimal totOreViaggio;

    @Column(name="REPERIBILITA")
    private int reperibilita;

    @Column(name="FLG_AUTO_PF")
    private String flgAutoPf;

    @Column(name="FLG_AUTO_AR")
    private String flgAutoAr;

}
