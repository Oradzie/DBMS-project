package azienda.data;

import java.time.LocalDate;

public class Lotto {

    public final String codiceLotto;
    public final LocalDate dataScadenza;

    public Lotto(String codiceLotto, LocalDate dataScadenza) {
        this.codiceLotto = codiceLotto;
        this.dataScadenza = dataScadenza;
    }

    public String getCodiceLotto() {
        return codiceLotto;
    }
    
    public LocalDate getDataScadenza() {
        return dataScadenza;
    }
    
}
