package azienda.data;

public class Prodotto {

    public final String numeroSeriale;
    public final String codiceLotto;
    public final String codicePacco;
    public final String codiceProdotto;
    public final String codiceRipiano;

    public Prodotto(String numeroSeriale, String codiceLotto, String codicePacco, String codiceProdotto,
            String codiceRipiano) {
        this.numeroSeriale = numeroSeriale;
        this.codiceLotto = codiceLotto;
        this.codicePacco = codicePacco;
        this.codiceProdotto = codiceProdotto;
        this.codiceRipiano = codiceRipiano;
    }

    public String getNumeroSeriale() {
        return numeroSeriale;
    }

    public String getCodiceLotto() {
        return codiceLotto;
    }

    public String getCodicePacco() {
        return codicePacco;
    }

    public String getCodiceProdotto() {
        return codiceProdotto;
    }
    
    public String getCodiceRipiano() {
        return codiceRipiano;
    }
    
}
