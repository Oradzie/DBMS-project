package azienda.model;

import azienda.commons.Pair;
import azienda.data.*;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public interface Model {
    // Create a model that connects to a database using the given connection.
    public static Model fromConnection(Connection connection) {
        return new DBModel(connection);
    }

    Optional<Integer> handleLogin(final String userID, final String password, final Boolean isDipendente);

    public List<Prodotto> getProducts();

    String getPassword(final String text, final boolean isDipendente);

    List<Pair<String, Integer>> getMonthlySales();

    Connection getConnection();

    List<Pair<String, Integer>> getProductSales();

    List<MyTableRow> getWarehouseStatistics();

    String getCurrentCodiceMagazzino();

    List<SalesRow> getSalesStatistics();

    List<MagazziniereRow> getDatiMagazzinieri();

    List<Fornitore> getFornitori();

    List<VersioneProdotto> getVersioniProdotto();

    boolean inlotraRichiestaRifornimento(Fornitore value, VersioneProdotto value1, int i);
}