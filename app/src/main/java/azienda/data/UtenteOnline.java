package azienda.data;

public class UtenteOnline {

    public final String codiceFiscale;
    public final String password;
    public final String email;

    public UtenteOnline(String codiceFiscale, String password, String email) {
        this.codiceFiscale = codiceFiscale;
        this.password = password;
        this.email = email;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
    
    
}
