package azienda.model;

import java.sql.Connection;
import java.util.List;
import java.util.Objects;

import azienda.data.Dipendente;
import azienda.data.Prodotto;
import azienda.data.UtenteOnline;

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
    public String getPassword(final String text, final boolean isDipendente) {
        if (isDipendente) {
            return Dipendente.DAO.handleLogin(this.connection, text).orElse(null);
        } else {
            return UtenteOnline.DAO.handleLogin(this.connection, text).orElse(null);
        }
    }
}