package azienda.data;

public class LocazioneUtente {

    public final String via;
    public final int cap;
    public final int numeroCivico;
    public final String codiceFiscale;

    public LocazioneUtente(String via, int cap, int numeroCivico, String codiceFiscale) {
        this.via = via;
        this.cap = cap;
        this.numeroCivico = numeroCivico;
        this.codiceFiscale = codiceFiscale;
    }

    public String getVia() {
        return via;
    }

    public int getCap() {
        return cap;
    }

    public int getNumeroCivico() {
        return numeroCivico;
    }
    
    public String getCodiceFiscale() {
        return codiceFiscale;
    }
    
}
