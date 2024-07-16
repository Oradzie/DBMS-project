package azienda.data;

import azienda.commons.DAOException;
import azienda.commons.DAOUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Optional;

public final class RegisteredUser {
    private final String username;
    private final String password;

    public RegisteredUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public final class DAO {

        public static Optional<RegisteredUser> find(final Connection connection, final String username) {
            try (
                    final PreparedStatement statement = DAOUtils.prepare(connection, Queries.FIND_USER, username);
                    final var resultSet = statement.executeQuery()
                    ) {
                if (resultSet.next()) {
                    return Optional.of(new RegisteredUser(resultSet.getString("username"), resultSet.getString("password")));
                } else {
                    return Optional.empty();
                }
            } catch (Exception e) {
                throw new DAOException(e);
            }
        }
    }
}
