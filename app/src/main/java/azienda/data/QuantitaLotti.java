package azienda.data;

public class QuantitaLotti {

    public final String codiceLotto;
    public final String codiceRifornimento;
    public final int numero;
    
    public QuantitaLotti(String codiceLotto, String codiceRifornimento, int numero) {
        this.codiceLotto = codiceLotto;
        this.codiceRifornimento = codiceRifornimento;
        this.numero = numero;
    }

    public String getCodiceLotto() {
        return codiceLotto;
    }

    public String getCodiceRifornimento() {
        return codiceRifornimento;
    }

    public int getNumero() {
        return numero;
    }
    
}
