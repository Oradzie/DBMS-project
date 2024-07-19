package azienda.data;

import azienda.commons.DAOException;
import azienda.commons.DAOUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class VersioneProdotto {

    public final String specifiche;
    public final int disponibilita;
    public final String codiceProdotto;
    public final String nomeProdotto;

    public VersioneProdotto(final String specifiche, final int disponibilita, final String codiceProdotto, final String nomeProdotto) {
        this.specifiche = specifiche;
        this.disponibilita = disponibilita;
        this.codiceProdotto = codiceProdotto;
        this.nomeProdotto = nomeProdotto;
    }

    public String getSpecifiche() {
        return specifiche;
    }

    public int getDisponibilita() {
        return disponibilita;
    }

    public String getCodiceProdotto() {
        return codiceProdotto;
    }
    
    public String getNomeProdotto() {
        return nomeProdotto;
    }

    @Override
    public String toString() {
        return nomeProdotto + "("+ codiceProdotto +")";
    }

    public static final class DAO {

        public static List<VersioneProdotto> list(final Connection connection) {
            try (
                    final PreparedStatement statement = DAOUtils.prepare(connection, Queries.LIST_VERSIONE_PRODOTTO);
                    var resultSet = statement.executeQuery();) {
                final List<VersioneProdotto> products = new ArrayList<>();

                while (resultSet.next()) {
                    products.add(new VersioneProdotto(
                            resultSet.getString("Specifiche"),
                            resultSet.getInt("Disponibilita"),
                            resultSet.getString("CodiceProdotto"),
                            resultSet.getString("NomeProdotto")));
                }

                return products;
            } catch (final Exception e) {
                throw new DAOException(e);
            }
        }
    }
}
