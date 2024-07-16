package azienda.data;

import java.time.LocalDate;

public class Magazzino {

    public final LocalDate dataFondazione;
    public final String codiceMagazzino;
    public final String via;
    public final int cap;
    public final int numeroCivico;

    public Magazzino(LocalDate dataFondazione, String codiceMagazzino, String via, int cap, int numeroCivico) {
        this.dataFondazione = dataFondazione;
        this.codiceMagazzino = codiceMagazzino;
        this.via = via;
        this.cap = cap;
        this.numeroCivico = numeroCivico;
    }

    public LocalDate getDataFondazione() {
        return dataFondazione;
    }

    public String getCodiceMagazzino() {
        return codiceMagazzino;
    }

    public String getVia() {
        return via;
    }

    public int getCap() {
        return cap;
    }

    public int getNumeroCivico() {
        return numeroCivico;
    }
    
}
