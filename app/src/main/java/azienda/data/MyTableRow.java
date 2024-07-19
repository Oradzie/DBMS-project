package azienda.data;

public class MyTableRow {
    
    public String codiceFiscale; 
    public String codiceDipendente;
    public String nome;
    public String cognome;
    public int numeroPacchiPreparati;
    
    public MyTableRow(String codiceFiscale, String codiceDipendente, String nome, String cognome,
            int numeroPacchiPreparati) {
        this.codiceFiscale = codiceFiscale;
        this.codiceDipendente = codiceDipendente;
        this.nome = nome;
        this.cognome = cognome;
        this.numeroPacchiPreparati = numeroPacchiPreparati;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public String getCodiceDipendente() {
        return codiceDipendente;
    }

    public void setCodiceDipendente(String codiceDipendente) {
        this.codiceDipendente = codiceDipendente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public int getNumeroPacchiPreparati() {
        return numeroPacchiPreparati;
    }

    public void setNumeroPacchiPreparati(int numeroPacchiPreparati) {
        this.numeroPacchiPreparati = numeroPacchiPreparati;
    }
}
