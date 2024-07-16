package azienda.data;

public class Persona {

    public final String nome;
    public final String cognome;
    public final String codiceFiscale;
    public final int telefono;
    
    public Persona(String nome, String cognome, String codiceFiscale, int telefono) {
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
        this.telefono = telefono;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }
    
    public int getTelefono() {
        return telefono;
    }
    
}
