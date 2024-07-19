package azienda.data;

public class SalesRow {
    private final String mese;
    private final String nomeProdotto;
    private final int numeroVendite;

    public SalesRow(final String mese, final String categoria, final int vendite) {
        this.mese = mese;
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
