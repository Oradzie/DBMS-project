package azienda.data;

import java.time.LocalDate;
import azienda.commons.DAOException;
import azienda.commons.DAOUtils;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Ordine {

    public final String codiceOrdine;
    public final LocalDate dataOrdine;
    public final String indirizzoDestinatario;
    public final String codiceSconto;
    public final String codicePromo;
    public final String codiceFiscale;

    public Ordine(String codiceOrdine, LocalDate dataOrdine, String indirizzoDestinatario, String codiceSconto,
            String codicePromo, String codiceFiscale) {
        this.codiceOrdine = codiceOrdine;
        this.dataOrdine = dataOrdine;
        this.indirizzoDestinatario = indirizzoDestinatario;
        this.codiceSconto = codiceSconto;
        this.codicePromo = codicePromo;
        this.codiceFiscale = codiceFiscale;
    }

    public String getCodiceOrdine() {
        return codiceOrdine;
    }

    public LocalDate getDataOrdine() {
        return dataOrdine;
    }

    public String getIndirizzoDestinatario() {
        return indirizzoDestinatario;
    }

    public String getCodiceSconto() {
        return codiceSconto;
    }

    public String getCodicePromo() {
        return codicePromo;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public static class DAO{
        public static List<StoricoOrdiniRow> showOrdini(final Connection connection,
                final String codiceFiscale) {
            try (
                    final PreparedStatement statement = DAOUtils.prepare(connection, Queries.VIEW_STORICO_ORDINI,
                            codiceFiscale);
                    var resultSet = statement.executeQuery();) {
                final List<StoricoOrdiniRow> storicoOrdini = new ArrayList<StoricoOrdiniRow>();
                while (resultSet.next()) {
                    storicoOrdini.add(new StoricoOrdiniRow(resultSet.getString("CodiceOrdine"),
                            resultSet.getString("DataOrdine"), resultSet.getString("IndirizzoDestinatario"),
                            resultSet.getString("CodiceSconto"), resultSet.getDouble("PercentualeScontoUtente"),
                            resultSet.getDouble("PercentualeSconto"),
                            resultSet.getString("CodiceProdotto"),
                            resultSet.getString("Specifiche"),
                            resultSet.getInt("Quantita"),
                            resultSet.getString("NumeroSeriale"),
                            resultSet.getString("CodiceLotto"),
                            resultSet.getString("CodPacco"),
                            resultSet.getString("CodiceFiscale"),
                            resultSet.getString("NomeCompleto")));
                }
                return storicoOrdini;
            } catch (Exception e) {
                throw new DAOException(e);
            }
        }
    }
    
}
