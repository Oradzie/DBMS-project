package azienda.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import azienda.commons.DAOException;
import azienda.commons.DAOUtils;

public class VenditaPromozionaleRaw {
    public final String codicePromo;
    public final String dataInizio;
    public final String dataFine;
    public final float percentualeSconto;

    public VenditaPromozionaleRaw(String codicePromo, String dataInizio, String dataFine, float percentualeSconto) {
        this.codicePromo = codicePromo;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.percentualeSconto = percentualeSconto;
    }

    public String getCodicePromo() {
        return codicePromo;
    }

    public String getDataInizio() {
        return dataInizio;
    }

    public String getDataFine() {
        return dataFine;
    }

    public float getPercentualeSconto() {
        return percentualeSconto;
    }

    public static final class DAO {

        public static List<VenditaPromozionaleRaw> list(final Connection connection) {
            try (
                    final PreparedStatement statement = DAOUtils.prepare(connection, Queries.LIST_PROMOZIONI);
                    var resultSet = statement.executeQuery();) {
                final List<VenditaPromozionaleRaw> promotions = new ArrayList<>();

                while (resultSet.next()) {
                    promotions.add(new VenditaPromozionaleRaw(
                            resultSet.getString("CodicePromo"),
                            resultSet.getString("DataInizio"),
                            resultSet.getString("DataFine"),
                            resultSet.getFloat("PercentualeSconto")));
                }

                return promotions;
            } catch (final Exception e) {
                throw new DAOException(e);
            }
        }
    }
}
