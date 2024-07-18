package azienda.data;

import azienda.commons.DAOException;
import azienda.commons.DAOUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Optional;

public class Dipendente implements Utente {

    private final String codiceFiscale;
    private final String codiceDipendente;
    private final String codiceMagazzino;
    private final String password;
    private final Boolean isAdmin;
    private final Boolean isMagazziniere;

    public Dipendente(final String codiceFiscale, final String codiceDipendente, final String codiceMagazzino,
                      final String password, final Boolean isAdmin, final Boolean isMagazziniere) {
        this.codiceFiscale = codiceFiscale;
        this.codiceDipendente = codiceDipendente;
        this.codiceMagazzino = codiceMagazzino;
        this.password = password;
        this.isAdmin = isAdmin;
        this.isMagazziniere = isMagazziniere;
    }

    public String getCodiceFiscale() {
        return this.codiceFiscale;
    }

    public String getCodiceDipendente() {
        return this.codiceDipendente;
    }

    public String getCodiceMagazzino() {
        return this.codiceMagazzino;
    }

    public String getPassword() {
        return this.password;
    }

    public Boolean isAdmin() {
        return this.isAdmin;
    }

    public Boolean isMagazziniere() {
        return this.isMagazziniere;
    }

    @Override
    public String toString() {
        return this.codiceDipendente;
    }

    public static final class DAO {

        public static Optional<String> handleLogin(final Connection connection, final String codiceDipendente) {
            try (
                    final PreparedStatement statement = DAOUtils.prepare(connection, Queries.FIND_DIPENDENTE, codiceDipendente);
                    var resultSet = statement.executeQuery();
            ) {
                if (resultSet.next()) {
                    return Optional.of(resultSet.getString("Password"));
                } else {
                    return Optional.empty();
                }
            } catch (Exception e) {
                throw new DAOException(e);
            }
        }

        public static Optional<String> getRelatedMagazzino(Connection connection, String currentUSer) {
            return null;
        }

        public static Optional<Dipendente> getDipendente(final Connection connection, final String userID) {
                try(
                        final PreparedStatement statement = DAOUtils.prepare(connection, Queries.FIND_DIPENDENTE, userID);
                        var resultSet = statement.executeQuery();
                ){
                    if (resultSet.next()) {
                        return Optional.of(new Dipendente(
                                resultSet.getString("CodiceFiscale"),
                                resultSet.getString("CodiceDipendente"),
                                resultSet.getString("CodMagazzino"),
                                resultSet.getString("Password"),
                                resultSet.getBoolean("Amministratore"),
                                resultSet.getBoolean("Magazziniere")));
                    }else{
                        return Optional.empty();
                    }
                } catch (Exception e) {
                    throw new DAOException(e);
                }
        }
    }
}
