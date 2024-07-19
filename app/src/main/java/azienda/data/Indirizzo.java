package azienda.data;

import java.io.IOError;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import azienda.commons.DAOException;
import azienda.commons.DAOUtils;

public class Indirizzo {

    public final String via;
    public final String citta;
    public final int cap;
    public final int numeroCivico;

    public Indirizzo(String via, String citta, int cap, int numeroCivico) {
        this.via = via;
        this.citta = citta;
        this.cap = cap;
        this.numeroCivico = numeroCivico;
    }

    public String getVia() {
        return via;
    }

    public String getCitta() {
        return citta;
    }

    public int getCap() {
        return cap;
    }

    public int getNumeroCivico() {
        return numeroCivico;
    }

    public static final class DAO {

        public static String addAddress(final Connection connection, final String Via,
                final String Citta, final String CAP, final String NumCivico) {
            String Via1 = new String("");
            String CAP1 = new String("");
            String NumCivico1 = new String("");
            try (
                    final PreparedStatement statement = DAOUtils.prepare(connection, Queries.ADD_ADDRESS,
                            Via, Citta, CAP, NumCivico);
                    ) {
                int result = statement.executeUpdate();
                if (result != 0) {
                    return "Indirizzo inserito!";
                } else {
                    return "Errore nell'inserimento dell'indirizzo";
                }
            } catch (SQLIntegrityConstraintViolationException e) {
                return "Indirizzo gia' esistente";
            } catch (Exception e) {
                throw new DAOException(e);
            }
        }
    }
}
