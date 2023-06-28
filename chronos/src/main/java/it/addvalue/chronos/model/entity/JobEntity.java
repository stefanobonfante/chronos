package it.addvalue.chronos.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_JOBS")
public class JobEntity {

  @Id
  @Column(name = "COD_JOB")
  private String codJob;

  @Column(name = "DES_JOB")
  private String desJob;

  @Column(name = "DES_JOB_BREVE")
  private String desJobBreve;

  @Column(name = "COD_CRESP")
  private String codCresp;

  @Column(name = "COD_SOCIETA")
  private String codSocieta;

  @Column(name = "COD_CLIENTE")
  private String codCliente;

  @Column(name = "RESP_JOB")
  private String respJob;

  @Column(name = "GG_PAGAMENTO")
  private int ggPagamento;

  @Column(name = "PROTOCOLLO")
  private String protocollo;

  @Column(name = "JOB_INTERNO")
  private String jobInterno;

  @Column(name = "DATA_INIZIO")
  private String dataInizio;

  @Column(name = "COD_STATO_JOB")
  private String codStatoJob;

  @Column(name = "GG_STIMA")
  private int ggStima;

  @Column(name = "GG_VENDUTI")
  private int ggVenduti;

  @Column(name = "TARIFFA")
  private int tariffa;

  @Column(name = "COMM_STIMA")
  private int commStima;

  @Column(name = "COMM_VENDITA")
  private int commVendita;

  @Column(name = "GG_CARICATI")
  private int ggCaricati;

  @Column(name = "GG_FINE_STIMA")
  private int ggFineStima;

  @Column(name = "GG_FINE_VENDI")
  private int ggFineVendi;

  @Column(name = "SPESE_JOB")
  private int speseJob;

  @Column(name = "COD_TIPO_JOB")
  private String codTipoJob;

  @Column(name = "CANCELLATO")
  private String cancellato;

  @Column(name = "COD_C_COSTO")
  private String codCCosto;

  @Column(name = "DATA_ORDINE")
  private String dataOrdine;

  @Column(name = "NUM_ORDINE")
  private String numOrdine;

  @Column(name = "DATA_PROPOSTA")
  private String dataProposta;

  @Column(name = "RESP_CLIENTE")
  private String respCliente;

  @Column(name = "RIF_APPL_CLI")
  private String rifApplCli;

  @Column(name = "RIF_BUYER_CLI")
  private String rifBuyerCli;

  @Column(name = "COD_STATO_PROP")
  private String codStatoProp;

  @Column(name = "PERC_ATTENDIB")
  private int precAttendib;

  @Column(name = "NOTA")
  private String nota;

  @Column(name = "DATA_FINE_PREV")
  private String dataFinePrev;

  @Column(name = "SPESE_FORFAIT")
  private int speseForfait;

  @Column(name = "OBB_TASK")
  private String obbTask;

  @Column(name = "OBB_SUBTASK")
  private String obbSubtask;

  @Column(name = "OBB_SUBSUBTASK")
  private String obbSubsubtask;

  @Column(name = "OBB_ATTIVITA")
  private String obbAttivita;

  @Column(name = "OBB_NOTE")
  private String obbNote;

  @Column(name = "FLG_MEZZORE")
  private String flgMezzore;

  @Column(name = "FLG_BUONOPASTO")
  private String flgBuonopasto;

  @Column(name = "FLG_RIEPILOGO")
  private String flgRieplogo;
}

