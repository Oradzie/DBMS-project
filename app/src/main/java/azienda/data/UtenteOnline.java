package azienda.data;

import azienda.commons.DAOException;
import azienda.commons.DAOUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Optional;

public class UtenteOnline {

    public final String codiceFiscale;
    public final String password;
    public final String email;

    public UtenteOnline(String codiceFiscale, String password, String email) {
        this.codiceFiscale = codiceFiscale;
        this.password = password;
        this.email = email;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public static final class DAO {

        public static Optional<String> handleLogin(final Connection connection, final String email) {
            try (
                    final PreparedStatement statement = DAOUtils.prepare(connection, Queries.FIND_UTENTE_ONLINE, email);
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
    }
}
