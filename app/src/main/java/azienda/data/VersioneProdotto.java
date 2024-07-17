package azienda.data;

public class VersioneProdotto {

    public final String Specifiche;
    public final int disponibilita;
    public final String CodiceProdotto;
    public final String NomeProdotto;

    public VersioneProdotto(String specifiche, int disponibilita, String codiceProdotto, String nomeProdotto) {
        Specifiche = specifiche;
        this.disponibilita = disponibilita;
        CodiceProdotto = codiceProdotto;
        NomeProdotto = nomeProdotto;
    }

    public String getSpecifiche() {
        return Specifiche;
    }

    public int getDisponibilita() {
        return disponibilita;
    }

    public String getCodiceProdotto() {
        return CodiceProdotto;
    }
    
    public String getNomeProdotto() {
        return NomeProdotto;
    }
    
}
