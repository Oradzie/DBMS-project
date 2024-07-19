package azienda.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
                    final PreparedStatement statement = DAOUtils.prepare(connection, Queries.FIND_VIA,
                            Via);
                    var resultSet = statement.executeQuery();) {
                if (resultSet.next())
                    Via1 = resultSet.getString(Via);

            } catch (Exception e) {
                throw new DAOException(e);
            }

            try (
                    final PreparedStatement statement = DAOUtils.prepare(connection, Queries.FIND_CAP,
                            CAP);
                    var resultSet = statement.executeQuery();) {
                if (resultSet.next())
                    CAP1 = resultSet.getString(CAP);

            } catch (Exception e) {
                throw new DAOException(e);
            }

            try (
                    final PreparedStatement statement = DAOUtils.prepare(connection, Queries.FIND_NUMCIVICO,
                            NumCivico);
                    var resultSet = statement.executeQuery();) {
                if (resultSet.next())
                    NumCivico1 = resultSet.getString(NumCivico);

            } catch (Exception e) {
                throw new DAOException(e);
            }
            if (NumCivico.equals(NumCivico1) && CAP.equals(CAP1) && Via.equals(Via1))
                return "Indirizzo gia' esistente";

            try (
                    final PreparedStatement statement = DAOUtils.prepare(connection, Queries.ADD_ADDRESS,
                            Via, Citta, CAP, NumCivico);) {

                return "Indirizzo inserito!";
            } catch (Exception e) {
                throw new DAOException(e);
            }
        }

    }

}
