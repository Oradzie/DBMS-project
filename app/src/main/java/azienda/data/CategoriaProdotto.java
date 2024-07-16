package azienda.data;

public class CategoriaProdotto {

    public final String NomeProdotto;
    public float PercentualeSconto;

    public CategoriaProdotto(String nomeProdotto, float percentualeSconto) {
        NomeProdotto = nomeProdotto;
        PercentualeSconto = percentualeSconto;
    }

    public String getNomeProdotto() {
        return NomeProdotto;
    }

    public float getPercentualeSconto() {
        return PercentualeSconto;
    }

    public void setPercentualeSconto(float percentualeSconto) {
        PercentualeSconto = percentualeSconto;
    }
    
}
