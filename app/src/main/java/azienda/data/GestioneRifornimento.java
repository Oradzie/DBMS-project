package azienda.data;

public class GestioneRifornimento {

    public final String codiceFiscale;
    public final String codiceRifornimento;

    public GestioneRifornimento(String codiceFiscale, String codiceRifornimento) {
        this.codiceFiscale = codiceFiscale;
        this.codiceRifornimento = codiceRifornimento;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }
    
    public String getCodiceRifornimento() {
        return codiceRifornimento;
    }

    
}
