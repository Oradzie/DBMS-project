package azienda.model;

import azienda.data.Prodotto;

import java.sql.Connection;
import java.util.List;

public interface Model {
     // Create a model that connects to a database using the given connection.
     public static Model fromConnection(Connection connection) {
        return new DBModel(connection);
    }

    public List<Prodotto> getProducts();
}