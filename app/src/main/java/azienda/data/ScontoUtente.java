package azienda.data;

public class ScontoUtente {

    public final float percentualeSconto;
    public final String codiceSconto;
    
    public ScontoUtente(float percentualeSconto, String codiceSconto) {
        this.percentualeSconto = percentualeSconto;
        this.codiceSconto = codiceSconto;
    }

    public float getPercentualeSconto() {
        return percentualeSconto;
    }

    public String getCodiceSconto() {
        return codiceSconto;
    }
    
}
