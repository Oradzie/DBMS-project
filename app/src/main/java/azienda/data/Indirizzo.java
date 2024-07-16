package azienda.data;

public class Indirizzo {

    public final String via;
    public final String città;
    public final int cap;
    public final int numeroCivico;

    public Indirizzo(String via, String città, int cap, int numeroCivico) {
        this.via = via;
        this.città = città;
        this.cap = cap;
        this.numeroCivico = numeroCivico;
    }

    public String getVia() {
        return via;
    }

    public String getCittà() {
        return città;
    }

    public int getCap() {
        return cap;
    }
    
    public int getNumeroCivico() {
        return numeroCivico;
    }
    
}
