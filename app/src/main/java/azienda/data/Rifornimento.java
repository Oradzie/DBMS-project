package azienda.data;

public class Rifornimento {

    public final String codiceRifornimento;
    public final String codiceFornitore;
    public final String codiceFiscale;

    public Rifornimento(String codiceRifornimento, String codiceFornitore, String codiceFiscale) {
        this.codiceRifornimento = codiceRifornimento;
        this.codiceFornitore = codiceFornitore;
        this.codiceFiscale = codiceFiscale;
    }

    public String getCodiceRifornimento() {
        return codiceRifornimento;
    }

    public String getCodiceFornitore() {
        return codiceFornitore;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }
    
    
}   
