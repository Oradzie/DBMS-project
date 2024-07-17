package azienda.data;

public class DettaglioOrdine {

    public final String codiceOrdine;
    public final int quantita;
    public final int numeroLinea;
    public final String codPacco;
    public final String codiceProdotto;
    public final String codMagazzino;

    public DettaglioOrdine(String codiceOrdine, int quantita, int numeroLinea, String codPacco, String codiceProdotto,
            String codMagazzino) {
        this.codiceOrdine = codiceOrdine;
        this.quantita = quantita;
        this.numeroLinea = numeroLinea;
        this.codPacco = codPacco;
        this.codiceProdotto = codiceProdotto;
        this.codMagazzino = codMagazzino;
    }

    public String getCodiceOrdine() {
        return codiceOrdine;
    }

    public int getQuantita() {
        return quantita;
    }

    public int getNumeroLinea() {
        return numeroLinea;
    }

    public String getCodPacco() {
        return codPacco;
    }

    public String getCodiceProdotto() {
        return codiceProdotto;
    }

    public String getCodMagazzino() {
        return codMagazzino;
    }
    
}