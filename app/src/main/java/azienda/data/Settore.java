package azienda.data;

public class Settore {

    public final String codiceSettore;
    public final String codiceMagazzino;
    
    public Settore(String codiceSettore, String codiceMagazzino) {
        this.codiceSettore = codiceSettore;
        this.codiceMagazzino = codiceMagazzino;
    }

    public String getCodiceSettore() {
        return codiceSettore;
    }

    public String getCodiceMagazzino() {
        return codiceMagazzino;
    }
 
}
