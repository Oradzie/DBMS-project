package azienda.data;

import azienda.commons.DAOException;
import azienda.commons.DAOUtils;
import azienda.commons.Pair;
import azienda.model.DBModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Magazzino {

    public final LocalDate dataFondazione;
    public final String codiceMagazzino;
    public final String via;
    public final int cap;
    public final int numeroCivico;

    public Magazzino(LocalDate dataFondazione, String codiceMagazzino, String via, int cap, int numeroCivico) {
        this.dataFondazione = dataFondazione;
        this.codiceMagazzino = codiceMagazzino;
        this.via = via;
        this.cap = cap;
        this.numeroCivico = numeroCivico;
    }

    public LocalDate getDataFondazione() {
        return dataFondazione;
    }

    public String getCodiceMagazzino() {
        return codiceMagazzino;
    }

    public String getVia() {
        return via;
    }

    public int getCap() {
        return cap;
    }

    public int getNumeroCivico() {
        return numeroCivico;
    }

    public static final class DAO {

        public static List<Pair<String, Integer>> getMonthlySales(final Connection connection, final String codiceMagazzino) {
            try (
                    final PreparedStatement statement = DAOUtils.prepare(connection, Queries.GET_MONTHLY_SALES, codiceMagazzino);
                    var resultSet = statement.executeQuery();
            ) {
                final List<Pair<String, Integer>> salesData = new ArrayList<Pair<String, Integer>>();
                while(resultSet.next()) {
                    salesData.add(new Pair<>(resultSet.getString("Mese"), resultSet.getInt("NumeroVendite")));
                }
                return salesData;
            } catch (Exception e) {
                throw new DAOException(e);
            }
        }
    }
}
