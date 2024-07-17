package azienda.data;

public class DatiFatturazione {

    public final String IBAN;
    public final String via;
    public final int cap;
    public final int numeroCivico;
    
    public DatiFatturazione(final String iBAN,final String Via, final int cAP, final int numeroCivico) {
        this.IBAN = iBAN;
        this.via = Via;
        this.cap = cAP;
        this.numeroCivico = numeroCivico;
    }

    public String getIBAN() {
        return IBAN;
    }

    public String getVia() {
        return via;
    }

    public int getCap() {
        return cap;
    }

    public int getNumeroCivico() {
        return numeroCivico;
    }
    
}