package azienda.data;

import azienda.commons.DAOException;
import azienda.commons.DAOUtils;
import azienda.commons.Pair;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLIntegrityConstraintViolationException;

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

    public static final class DAO {

        public static Pair<Boolean, String> addDettaglio(final Connection connection, final String codiceOrdine,
                final Integer quantita, final Integer numeroLinea, final String codiceProdotto) {
            try (
                    final PreparedStatement statement = DAOUtils.prepare(connection, Queries.ADD_DETTAGLIO_ORDINE,
                            codiceOrdine, quantita, numeroLinea, codiceProdotto, "MAG001");) {
                int result = statement.executeUpdate();
                if (result != 0) {
                    return new Pair<>(true, "Prodotto inserito nel carrello");
                } else {
                    return new Pair<>(false, "Errore nell'inserimento del prodotto");
                }
            } catch (SQLIntegrityConstraintViolationException e) {
                return new Pair<>(false, "Errore nell'inserimento del prodotto");
            } catch (Exception e) {
                throw new DAOException(e);
            }
        }
    }
}
