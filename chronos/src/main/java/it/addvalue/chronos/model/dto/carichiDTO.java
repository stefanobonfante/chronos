package it.addvalue.chronos.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class carichiDTO {

  private int IdCarico;

  private String codUtente;

  private int anno;

  private int mese;

  private int giorno;

  private String codJob;

  private String codTask;

  private String codSTask;

  private String codSSTask;

  private String codAttivita;

  private String oraInizioStr;

  private String flgStr;

  private int ore;

  private String note;

  private String flgChiuso;

  private String codLgLav;

  private String ultimaMod;

  private String autore;

  private String flgLavoroRem;
}
