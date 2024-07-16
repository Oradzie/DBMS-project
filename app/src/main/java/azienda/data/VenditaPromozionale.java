package azienda.data;

import java.time.LocalDate;

public class VenditaPromozionale {

    public final String codicePromo;
    public final LocalDate dataInizio;
    public final LocalDate dataFine;
    public final float percentualeSconto;

    public VenditaPromozionale(String codicePromo, LocalDate dataInizio, LocalDate dataFine, float percentualeSconto) {
        this.codicePromo = codicePromo;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.percentualeSconto = percentualeSconto;
    }

    public String getCodicePromo() {
        return codicePromo;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }

    public float getPercentualeSconto() {
        return percentualeSconto;
    }
    
}
