package azienda.data;

import java.time.LocalDate;

public class Inventario {

    public final String codiceFiscaleAmministratore;
    public final LocalDate data;
    public final String codiceFiscaleMagazziniere;

    
    public Inventario(String codiceFiscaleAmministratore, LocalDate data, String codiceFiscaleMagazziniere) {
        this.codiceFiscaleAmministratore = codiceFiscaleAmministratore;
        this.data = data;
        this.codiceFiscaleMagazziniere = codiceFiscaleMagazziniere;
    }

    public LocalDate getData() {
        return data;
    }

    public String getCodiceFiscaleAmministratore() {
        return codiceFiscaleAmministratore;
    }

    public String getCodiceFiscaleMagazziniere() {
        return codiceFiscaleMagazziniere;
    }
     
    
}