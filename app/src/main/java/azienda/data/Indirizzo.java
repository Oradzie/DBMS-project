package azienda.data;

public class Indirizzo {

    public final String via;
    public final String citta;
    public final int cap;
    public final int numeroCivico;

    public Indirizzo(String via, String citta, int cap, int numeroCivico) {
        this.via = via;
        this.citta = citta;
        this.cap = cap;
        this.numeroCivico = numeroCivico;
    }

    public String getVia() {
        return via;
    }

    public String getCitta() {
        return citta;
    }

    public int getCap() {
        return cap;
    }
    
    public int getNumeroCivico() {
        return numeroCivico;
    }
    
}
