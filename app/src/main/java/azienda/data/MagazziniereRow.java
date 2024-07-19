package azienda.data;



public class MagazziniereRow {
    private final String CodiceDipendente;
    private final String Cognome;
    private final String Nome;
    private final String telefono;
    private final String IBAN;
    private final String Via;
    private final int CAP;
    private final int NumCivico;

    public MagazziniereRow(String codiceDipendente, String cognome, String nome, String telefono, String iBAN,
            String via, int cAP, int numCivico) {
        CodiceDipendente = codiceDipendente;
        Cognome = cognome;
        Nome = nome;
        this.telefono = telefono;
        IBAN = iBAN;
        Via = via;
        CAP = cAP;
        NumCivico = numCivico;
    }

    public String getCodiceDipendente() {
        return CodiceDipendente;
    }

    public String getCognome() {
        return Cognome;
    }

    public String getNome() {
        return Nome;
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
    
    public int getNumCivico() {
        return NumCivico;
    }

    public String getTelefono() {
        return telefono;
    }
    

}
