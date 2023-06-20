package it.addvalue.chronos.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_CARICHI")
public class CarichiEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String IdCarico;

    @Column(name = "COD_UTENTE")
    private String codUtente;

    @Column(name = "ANNO")
    private int anno;

    @Column(name = "MESE")
    private int mese;

    @Column(name = "GIORNO")
    private int giorno;

    @Column(name = "COD_JOB")
    private String codJob;

    @Column(name = "COD_TASK")
    private String codTask;

    @Column(name = "COD_SUBTASK")
    private String codSTask;

    @Column(name = "COD_SUBSUBTASK")
    private String codSSTask;

    @Column(name = "COD_ATTIVITA")
    private String codAttivita;

    @Column(name = "ORA_INIZIO_STRAO")
    private String oraInizioStr;

    @Column(name = "FLG_STRAO")
    private String flgStr;

    @Column(name = "ORE")
    private int ore;

    @Column(name = "NOTE")
    private String note;

    @Column(name = "FLG_CHIUSO")
    private String flgChiuso;

    @Column(name = "COD_LUOGO_LAV")
    private String codLgLav;

    @Column(name = "TMS_ULTIMAMOD")
    private String ultimaMod;

    @Column(name = "AUTORE_INSERIMENTO")
    private String autore;

    @Column(name = "FLG_LAVORO_REMOTO")
    private String flgLavoroRem;
}
