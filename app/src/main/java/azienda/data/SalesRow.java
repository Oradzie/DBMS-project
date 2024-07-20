package azienda.data;

import java.time.Month;

public class SalesRow {
    private final String mese;
    private final String nomeProdotto;
    private final int numeroVendite;

    public SalesRow(final String mese, final String categoria, final int vendite) {
        this.mese = Month.of(Integer.parseInt(mese)).getDisplayName(java.time.format.TextStyle.FULL, java.util.Locale.ITALIAN);
        this.nomeProdotto = categoria;
        this.numeroVendite = vendite;
    }

    public String getMese() {
        return mese;
    }

    public String getNomeProdotto() {
        return nomeProdotto;
    }

    public int getNumeroVendite() {
        return numeroVendite;
    }
}
