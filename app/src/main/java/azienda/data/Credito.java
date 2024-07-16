package azienda.data;

public class Credito {
    
    public final String CodiceSconto;
    public final String CodiceFiscale;

    public Credito(String codiceSconto, String codiceFiscale) {
        CodiceSconto = codiceSconto;
        CodiceFiscale = codiceFiscale;
    }

    public String getCodiceSconto() {
        return CodiceSconto;
    }
    
    public String getCodiceFiscale() {
        return CodiceFiscale;
    }

}
