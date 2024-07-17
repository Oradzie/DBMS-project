package azienda.model;

import java.sql.Connection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import azienda.data.Dipendente;
import azienda.data.Prodotto;

public final class DBModel implements Model {

    private final Connection connection;

    public DBModel(Connection connection) {
        Objects.requireNonNull(connection, "Model created with null connection");
        this.connection = connection;
    }

    @Override
    public List<Prodotto> getProducts() {
        return Prodotto.DAO.list(this.connection);
    }

    @Override
    public String getPassword(final String codiceDipendente) {
        return Dipendente.DAO.handleLogin(this.connection, codiceDipendente).orElse(null);
    }
}