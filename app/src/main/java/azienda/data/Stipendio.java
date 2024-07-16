package azienda.data;

import java.time.LocalDate;

public class Stipendio {

    public final String codiceFiscale;
    public final float importo;
    public final float bonus;
    public final LocalDate dataEmissione;
    public final String iban;

    public Stipendio(String codiceFiscale, float importo, float bonus, LocalDate dataEmissione, String iban) {
        this.codiceFiscale = codiceFiscale;
        this.importo = importo;
        this.bonus = bonus;
        this.dataEmissione = dataEmissione;
        this.iban = iban;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public float getImporto() {
        return importo;
    }

    public float getBonus() {
        return bonus;
    }

    public LocalDate getDataEmissione() {
        return dataEmissione;
    }

    public String getIban() {
        return iban;
    }
    
    
}
