package azienda.data;

public class Scaffale {

    public final String codiceScaffale;
    public final String codiceSettore;
    
    public Scaffale(String codiceScaffale, String codiceSettore) {
        this.codiceScaffale = codiceScaffale;
        this.codiceSettore = codiceSettore;
    }

    public String getCodiceScaffale() {
        return codiceScaffale;
    }

    public String getCodiceSettore() {
        return codiceSettore;
    }
    
}
