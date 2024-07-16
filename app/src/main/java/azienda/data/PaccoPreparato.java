package azienda.data;

public class PaccoPreparato {

    public final String codicePacco;
    public final String codiceFiscale;
    
    public PaccoPreparato(String codicePacco, String codiceFiscale) {
        this.codicePacco = codicePacco;
        this.codiceFiscale = codiceFiscale;
    }

    public String getCodicePacco() {
        return codicePacco;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }
    
}
