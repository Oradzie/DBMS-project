package azienda.data;

public class Ripiano {

    public final String codiceRipiano;
    public final String codiceScaffale;
    
    public Ripiano(String codiceRipiano, String codiceScaffale) {
        this.codiceRipiano = codiceRipiano;
        this.codiceScaffale = codiceScaffale;
    }

    public String getCodiceRipiano() {
        return codiceRipiano;
    }

    public String getCodiceScaffale() {
        return codiceScaffale;
    }
    
}
