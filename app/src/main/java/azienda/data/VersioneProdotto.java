package azienda.data;

public class VersioneProdotto {

    public final String Specifiche;
    public final int Disponibilità;
    public final String CodiceProdotto;
    public final String NomeProdotto;

    public VersioneProdotto(String specifiche, int disponibilità, String codiceProdotto, String nomeProdotto) {
        Specifiche = specifiche;
        Disponibilità = disponibilità;
        CodiceProdotto = codiceProdotto;
        NomeProdotto = nomeProdotto;
    }

    public String getSpecifiche() {
        return Specifiche;
    }

    public int getDisponibilità() {
        return Disponibilità;
    }

    public String getCodiceProdotto() {
        return CodiceProdotto;
    }
    
    public String getNomeProdotto() {
        return NomeProdotto;
    }
    
}
