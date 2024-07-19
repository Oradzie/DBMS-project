package azienda.data;

import java.time.LocalDate;

public class Ordine {

    public final String codiceOrdine;
    public final LocalDate dataOrdine;
    public final String indirizzoDestinatario;
    public final String codiceSconto;
    public final String codicePromo;
    public final String codiceFiscale;

    public Ordine(String codiceOrdine, LocalDate dataOrdine, String indirizzoDestinatario, String codiceSconto,
            String codicePromo, String codiceFiscale) {
        this.codiceOrdine = codiceOrdine;
        this.dataOrdine = dataOrdine;
        this.indirizzoDestinatario = indirizzoDestinatario;
        this.codiceSconto = codiceSconto;
        this.codicePromo = codicePromo;
        this.codiceFiscale = codiceFiscale;
    }

    public String getCodiceOrdine() {
        return codiceOrdine;
    }

    public LocalDate getDataOrdine() {
        return dataOrdine;
    }

    public String getIndirizzoDestinatario() {
        return indirizzoDestinatario;
    }

    public String getCodiceSconto() {
        return codiceSconto;
    }

    public String getCodicePromo() {
        return codicePromo;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

}
