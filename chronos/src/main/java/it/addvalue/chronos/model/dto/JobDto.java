package it.addvalue.chronos.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobDto {
    private String codJob;
    private String desJob;
    private String desJobBreve;
    private String codCresp;
    private String codSocieta;
    private String codCliente;
    private String respJob;
    private BigDecimal ggPagamento;
    private String protocollo;
    private String jobInterno;
    private String dataInizio;
    private String codStatoJob;
    private BigDecimal ggStima;
    private BigDecimal ggVenduti;
    private BigDecimal tariffa;
    private BigDecimal commStima;
    private BigDecimal commVendita;
    private BigDecimal ggCaricati;
    private BigDecimal ggFineStima;
    private BigDecimal ggFineVendi;
    private BigDecimal speseJob;
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
    private BigDecimal precAttendib;
    private String nota;
    private String dataFinePrev;
    private BigDecimal speseForfait;
    private String obbTask;
    private String obbSubtask;
    private String obbSubsubtask;
    private String obbAttivita;
    private String obbNote;
    private String flgMezzore;
    private String flgBuonopasto;
    private String flgRiepilogo;
}