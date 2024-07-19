package azienda.data;

import azienda.commons.DAOException;
import azienda.commons.DAOUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Fornitore {

    public final String codiceFornitore;

    public Fornitore(String codiceFornitore) {
        this.codiceFornitore = codiceFornitore;
    }

    public String getCodiceFornitore() {
        return codiceFornitore;
    }

    @Override
    public String toString() {
        return "Fornitore: " + codiceFornitore;
    }

    public static final class DAO {

        public static List<Fornitore> listAll(final Connection connection) {
            try (
                    final PreparedStatement statement = DAOUtils.prepare(connection, Queries.LIST_FORNITORI);
                    var resultSet = statement.executeQuery();
                    ) {
                final List<Fornitore> fornitori = new ArrayList<Fornitore>();
                while (resultSet.next()) {
                    fornitori.add(new Fornitore(resultSet.getString("CodiceFornitore")));
                }

                return fornitori;
            } catch (final Exception e) {
                throw new DAOException(e);
            }
        }
    }
}
