package azienda.data;

public class DatiFatturazione {

    public final String IBAN;
    public final String Via;
    public final int CAP;
    public final int NumeroCivico;
    
    public DatiFatturazione(String iBAN, String via, int cAP, int numeroCivico) {
        IBAN = iBAN;
        Via = via;
        CAP = cAP;
        NumeroCivico = numeroCivico;
    }

    public String getIBAN() {
        return IBAN;
    }

    public String getVia() {
        return Via;
    }

    public int getCAP() {
        return CAP;
    }

    public int getNumeroCivico() {
        return NumeroCivico;
    }
    
}
