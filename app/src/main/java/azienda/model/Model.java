package azienda.model;

import java.sql.Connection;

public interface Model {
     // Create a model that connects to a database using the given connection.
     public static Model fromConnection(Connection connection) {
        return new DBModel(connection);
    }

    public void login(final String username, final String password);
    
}