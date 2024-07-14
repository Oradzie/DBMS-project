package azienda.model;

public final class Model {
    // Create a model that connects to a database using the given connection.
    public static Model fromConnection(Connection connection) {
        return new DBModel(connection);
    }
}