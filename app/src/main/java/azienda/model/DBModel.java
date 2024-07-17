package azienda.model;

import java.sql.Connection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import azienda.data.Prodotto;

// This is the real model implementation that uses the DAOs we've defined to
// actually load data from the underlying database.
//
// As you can see this model doesn't do too much except loading data from the
// database and keeping a cache of the loaded previews.
// A real model might be doing much more, but for the sake of the example we're
// keeping it simple.
//
public final class DBModel implements Model {

    private final Connection connection;

    public DBModel(Connection connection) {
        Objects.requireNonNull(connection, "Model created with null connection");
        this.connection = connection;
    }


    /**
     * @return
     */
    @Override
    public List<Prodotto> getProducts() {
        return Prodotto.DAO.list(this.connection);
    }
}