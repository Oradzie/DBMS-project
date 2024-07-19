package azienda.data;

public class StoricoOrdiniRow {
    private String codiceOrdine;
    private String dataOrdine;
    private String indirizzoDestinatario;
    private String codiceSconto;
    private Double percentualeScontoUtente;
    private Double percentualeScontoPromo;
    private String codiceProdotto;
    private String specifiche;
    private Integer quantita;
    private String numeroSeriale;
    private String codiceLotto;
    private String codPacco;
    private String codiceFiscale;
    private String nomeCompleto;

    public StoricoOrdiniRow(String codiceOrdine, String dataOrdine, String indirizzoDestinatario, String codiceSconto,
                            Double percentualeScontoUtente, Double percentualeScontoPromo, String codiceProdotto,
                            String specifiche, Integer quantita, String numeroSeriale, String codiceLotto,
                            String codPacco, String codiceFiscale, String nomeCompleto) {
        this.codiceOrdine = codiceOrdine;
        this.dataOrdine = dataOrdine;
        this.indirizzoDestinatario = indirizzoDestinatario;
        this.codiceSconto = codiceSconto;
        this.percentualeScontoUtente = percentualeScontoUtente;
        this.percentualeScontoPromo = percentualeScontoPromo;
        this.codiceProdotto = codiceProdotto;
        this.specifiche = specifiche;
        this.quantita = quantita;
        this.numeroSeriale = numeroSeriale;
        this.codiceLotto = codiceLotto;
        this.codPacco = codPacco;
        this.codiceFiscale = codiceFiscale;
        this.nomeCompleto = nomeCompleto;
    }

    public String getCodiceOrdine() {
        return codiceOrdine;
    }

    public void setCodiceOrdine(String codiceOrdine) {
        this.codiceOrdine = codiceOrdine;
    }

    public String getDataOrdine() {
        return dataOrdine;
    }

    public void setDataOrdine(String dataOrdine) {
        this.dataOrdine = dataOrdine;
    }

    public String getIndirizzoDestinatario() {
        return indirizzoDestinatario;
    }

    public void setIndirizzoDestinatario(String indirizzoDestinatario) {
        this.indirizzoDestinatario = indirizzoDestinatario;
    }

    public String getCodiceSconto() {
        return codiceSconto;
    }

    public void setCodiceSconto(String codiceSconto) {
        this.codiceSconto = codiceSconto;
    }

    public Double getPercentualeScontoUtente() {
        return percentualeScontoUtente;
    }

    public void setPercentualeScontoUtente(Double percentualeScontoUtente) {
        this.percentualeScontoUtente = percentualeScontoUtente;
    }

    public Double getPercentualeScontoPromo() {
        return percentualeScontoPromo;
    }

    public void setPercentualeScontoPromo(Double percentualeScontoPromo) {
        this.percentualeScontoPromo = percentualeScontoPromo;
    }

    public String getCodiceProdotto() {
        return codiceProdotto;
    }

    public void setCodiceProdotto(String codiceProdotto) {
        this.codiceProdotto = codiceProdotto;
    }

    public String getSpecifiche() {
        return specifiche;
    }

    public void setSpecifiche(String specifiche) {
        this.specifiche = specifiche;
    }

    public Integer getQuantita() {
        return quantita;
    }

    public void setQuantita(Integer quantita) {
        this.quantita = quantita;
    }

    public String getNumeroSeriale() {
        return numeroSeriale;
    }

    public void setNumeroSeriale(String numeroSeriale) {
        this.numeroSeriale = numeroSeriale;
    }

    public String getCodiceLotto() {
        return codiceLotto;
    }

    public void setCodiceLotto(String codiceLotto) {
        this.codiceLotto = codiceLotto;
    }

    public String getCodPacco() {
        return codPacco;
    }

    public void setCodPacco(String codPacco) {
        this.codPacco = codPacco;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }
}
