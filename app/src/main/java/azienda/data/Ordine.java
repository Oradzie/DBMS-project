package azienda.data;

import java.time.LocalDate;
import azienda.commons.DAOException;
import azienda.commons.DAOUtils;
import azienda.commons.Pair;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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

    public static class DAO {
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

        public static Pair<String, String> addOrdine(final Connection connection,
                final LocalDate data, final String indirizzoDestinatario,
                String codiceSconto, String codicePromo, final String codiceFiscale) {
            if (codicePromo.length() < 4)
                codicePromo = null;
            if (codiceSconto.length() < 4)
                codiceSconto = null;
            String codiceOrdine = "";
            try (
                    final PreparedStatement statement = DAOUtils.prepare(connection, Queries.VIEW_ORDINI);
                    var resultSet = statement.executeQuery();) {
                Random random = new Random();
                List<String> codici = new ArrayList<>();
                while (resultSet.next()) {
                    codici.add(resultSet.getString("CodiceOrdine"));
                }
                do {
                    codiceOrdine = "COD";
                    codiceOrdine = codiceOrdine.concat(String.valueOf(random.nextInt(10000)));
                    System.out.println(codiceOrdine);
                } while (codici.contains(codiceOrdine));

            } catch (Exception e) {
                throw new DAOException(e);
            }

            try (
                    final PreparedStatement statement = DAOUtils.prepare(connection, Queries.ADD_ORDINE,
                            codiceOrdine, data, indirizzoDestinatario, codiceSconto, codicePromo, codiceFiscale);) {
                int result = statement.executeUpdate();
                if (result != 0) {
                    return new Pair<>(codiceOrdine, "Ordine inserito, ora puoi iniziare a inserire prodotti");
                } else {
                    return new Pair<>(codiceOrdine, "Errore nell'inserimento dell'ordine");
                }

            } catch (SQLIntegrityConstraintViolationException e) {
                return new Pair<>(codiceOrdine, "Ordine già esistente");
            } catch (Exception e) {
                throw new DAOException(e);
            }

        }

    }

}
