package it.addvalue.chronos.model.dto;

import lombok.*;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class JobDTO {
  private String codJob;

  private String desJob;

  private String desJobBreve;

  private String codCresp;

  private String codSocieta;

  private String codCliente;

  private String respJob;

  private int ggPagamento;

  private String protocollo;

  private String jobInterno;

  private String dataInizio;

  private String codStatoJob;

  private int ggStima;

  private int ggVenduti;

  private int tariffa;

  private int commStima;

  private int commVendita;

  private int ggCaricati;

  private int ggFineStima;

  private int ggFineVendi;

  private int speseJob;

  private String codTipoJob;

  private String cancellato;

  private String codCCosto;

  private String dataOrdine;

  private String numOrdine;

  private String dataProposta;

  private String respCliente;

  private String rifApplCli;

  private String rifBuyerCli;

  private String codStatoProp;

  private int precAttendib;

  private String nota;

  private String dataFinePrev;

  private int speseForfait;

  private String obbTask;

  private String obbSubtask;

  private String obbSubsubtask;

  private String obbAttivita;

  private String obbNote;

  private String flgMezzore;

  private String flgBuonopasto;

  private String flgRieplogo;
}
