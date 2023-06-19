package it.addvalue.chronos.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpeseDto {
    private String idSpese;

    private String codUtente;

    private String codJob;

    private int anno;

    private int mese;

    private int giorno;

    private String percorso;

    private int kmPercorsi;

    private int rimborsoKm;

    private int carburante;

    private int pedaggi;

    private int altro;

    private int anticipi;

    private int parcheggi;

    private int trasporti;

    private int totSpese;

    private int trasferta;

}
