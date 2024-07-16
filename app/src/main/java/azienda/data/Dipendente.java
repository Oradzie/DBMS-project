package azienda.data;

public class Dipendente extends Persona{

    public final String CodiceDipendente;
    public final String CodiceMagazzino;
    public final String Password;
    public DatiFatturazione datiFatturazione;
    

    public Dipendente(String nome, String cognome, String codiceFiscale, int telefono, String codiceDipendente,
            String codiceMagazzino, String password, DatiFatturazione datiFatturazione) {
        super(nome, cognome, codiceFiscale, telefono);
        CodiceDipendente = codiceDipendente;
        CodiceMagazzino = codiceMagazzino;
        Password = password;
        this.datiFatturazione = datiFatturazione;
    }

    public String getCodiceDipendente() {
        return CodiceDipendente;
    }

    public String getCodiceMagazzino() {
        return CodiceMagazzino;
    }

    public String getPassword() {
        return Password;
    }

    public DatiFatturazione getDatiFatturazione() {
        return datiFatturazione;
    }

    public void setDatiFatturazione(DatiFatturazione datiFatturazione) {
        this.datiFatturazione = datiFatturazione;
    }
    
    
}
