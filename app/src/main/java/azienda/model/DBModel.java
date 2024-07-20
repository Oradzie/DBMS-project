package azienda.model;

import java.sql.Connection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import azienda.commons.Pair;
import azienda.data.*;

public final class DBModel implements Model {

    private final Connection connection;
    private Utente currentUSer;
    private String lastOrderAdded = "";
    private Integer lastLineaAdded = 0;

    public DBModel(Connection connection) {
        Objects.requireNonNull(connection, "Model created with null connection");
        this.connection = connection;
    }

    @Override
    public Optional<Integer> handleLogin(final String userID, final String password, final Boolean isDipendente) {
        if (isDipendente) {
            return Dipendente.DAO.getDipendente(this.connection, userID)
                    .flatMap(dipendente -> {
                        if (dipendente.getPassword().equals(password)) {
                            this.currentUSer = dipendente;
                            if (dipendente.isAdmin()) {
                                return Optional.of(0);
                            } else {
                                return Optional.of(1);
                            }
                        } else {
                            return Optional.empty();
                        }
                    });
        } else {
            return UtenteOnline.DAO.getUtente(this.connection, userID)
                    .flatMap(utenteOnline -> {
                        if (utenteOnline.getPassword().equals(password)) {
                            this.currentUSer = utenteOnline;
                            return Optional.of(2);
                        } else {
                            return Optional.empty();
                        }
                    });
        }
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

    @Override
    public List<Pair<String, Integer>> getMonthlySales() {
        final Dipendente user = (Dipendente) this.currentUSer;
        return Magazzino.DAO.getMonthlySales(this.connection, user.getCodiceMagazzino());
    }

    @Override
    public Connection getConnection() {
        return this.connection;
    }

    @Override
    public List<Pair<String, Integer>> getProductSales() {
        final Dipendente user = (Dipendente) this.currentUSer;
        return Magazzino.DAO.getProductSales(this.connection, user.getCodiceMagazzino());
    }

    @Override
    public List<MyTableRow> getWarehouseStatistics() {
        final Dipendente user = (Dipendente) this.currentUSer;
        return Magazziniere.DAO.showWarehouseStatistics(this.connection, user.getCodiceMagazzino());
    }

    @Override
    public String getCurrentCodiceMagazzino() {
        final Dipendente user = (Dipendente) this.currentUSer;
        return user.getCodiceMagazzino();
    }

    @Override
    public List<SalesRow> getSalesStatistics() {
        final Dipendente user = (Dipendente) this.currentUSer;
        return Magazzino.DAO.mostSaledProduct(this.connection, user.getCodiceMagazzino());
    }

    @Override
    public List<MagazziniereRow> getDatiMagazzinieri() {
        final Dipendente user = (Dipendente) this.currentUSer;
        return Magazziniere.DAO.showDatiMagazzinieri(this.connection, user.getCodiceMagazzino());
    }

    @Override
    public List<Fornitore> getFornitori() {
        return Fornitore.DAO.listAll(this.connection);
    }

    @Override
    public List<VersioneProdotto> getVersioniProdotto() {
        return VersioneProdotto.DAO.list(this.connection);
    }

    @Override
    public List<VenditaPromozionaleRaw> getPromozioni() {
        return VenditaPromozionaleRaw.DAO.list(this.connection);
    }

    @Override
    public List<StoricoOrdiniRow> getStoricoOrdini() {
        final UtenteOnline user = (UtenteOnline) this.currentUSer;
        return Ordine.DAO.showOrdini(this.connection, user.getCodiceFiscale());
    }

    @Override
    public boolean inlotraRichiestaRifornimento(final Fornitore fornitore, final VersioneProdotto prodotto,
            final int quantity) {
        final Dipendente user = (Dipendente) this.currentUSer;
        return Rifornimento.DAO.addRifornimento(this.connection, user.getCodiceFiscale(), fornitore, quantity);
    }

    @Override
    public String getCurrentUser() {
        return this.currentUSer.getCodiceFiscale();
    }

    @Override
    public void setLastOrderAdded(String codiceOrdine) {
        this.lastOrderAdded = codiceOrdine;
    }

    @Override
    public String getLastOrderAdded() {
        return this.lastOrderAdded;
    }

    @Override
    public void setLastLineaAdded(Integer numeroLinea) {
        this.lastLineaAdded = numeroLinea;
    }

    @Override
    public Integer getLastLineaAdded() {
        return this.lastLineaAdded;
    }
}